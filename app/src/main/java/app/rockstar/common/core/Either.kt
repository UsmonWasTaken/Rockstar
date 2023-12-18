/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

@file:Suppress("NOTHING_TO_INLINE")

package app.rockstar.common.core

import kotlin.coroutines.cancellation.CancellationException

sealed interface Either<out Data, out Cause> {

  @JvmInline
  value class Success<out Data>(val data: Data) : Either<Data, Nothing>

  @JvmInline
  value class Failure<out Cause>(val cause: Cause) : Either<Nothing, Cause>

  companion object {

    @JvmStatic
    inline fun <Data> Data.asSuccess(): Either<Data, Nothing> = Success(data = this)

    @JvmStatic
    inline fun <Cause> Cause.asFailure(): Either<Nothing, Cause> = Failure(cause = this)

    @JvmStatic
    inline fun <Data> of(block: () -> Data): Either<Data, Throwable> = try {
      Success(data = block())
    } catch (cancellation: CancellationException) {
      throw cancellation
    } catch (throwable: Throwable) {
      Failure(cause = throwable)
    }
  }
}
