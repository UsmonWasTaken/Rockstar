/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.genre

import app.rockstar.common.core.Either
import app.rockstar.domain.model.Genre
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface GenreRepository {

  suspend fun getGenreById(genreId: Long): Either<Genre, Throwable>

  suspend fun getGenres(): ImmutableList<Genre>

  fun observeGenres(): Flow<ImmutableList<Genre>>
}
