/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package app.rockstar.common.core

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

object EitherUtil {

  @JvmStatic
  inline fun Either<*, *>.isSuccess(): Boolean {
    contract {
      returns(true) implies (this@isSuccess is Either.Success)
      returns(false) implies (this@isSuccess is Either.Failure)
    }
    return this is Either.Success
  }

  @JvmStatic
  inline fun Either<*, *>.isFailure(): Boolean {
    contract {
      returns(true) implies (this@isFailure is Either.Failure)
      returns(false) implies (this@isFailure is Either.Success)
    }
    return this is Either.Failure
  }

  @JvmStatic
  inline fun <D, C, R> Either<D, C>.fold(
    onSuccess: (data: D) -> R,
    onFailure: (cause: C) -> R,
  ): R {
    contract {
      callsInPlace(onSuccess, InvocationKind.AT_MOST_ONCE)
      callsInPlace(onFailure, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
      is Either.Success -> onSuccess(data)
      is Either.Failure -> onFailure(cause)
    }
  }

  @JvmStatic
  inline fun <D, C, T> Either<D, C>.map(transform: (data: D) -> T): Either<T, C> {
    contract {
      callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
      is Either.Success -> Either.Success(transform(data))
      is Either.Failure -> this
    }
  }

  @JvmStatic
  inline fun <D, C, T> Either<D, C>.mapFailure(transform: (cause: C) -> T): Either<D, T> {
    contract {
      callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
      is Either.Success -> this
      is Either.Failure -> Either.Failure(transform(cause))
    }
  }

  @JvmStatic
  inline fun <D, C, T> Either<D, C>.flatMap(transform: (data: D) -> Either<T, C>): Either<T, C> {
    contract {
      callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
      is Either.Success -> transform(data)
      is Either.Failure -> this
    }
  }

  @JvmStatic
  inline fun <D, C, T> Either<D, C>.flatMapFailure(transform: (cause: C) -> Either<D, T>): Either<D, T> {
    contract {
      callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
      is Either.Success -> this
      is Either.Failure -> transform(cause)
    }
  }
}
