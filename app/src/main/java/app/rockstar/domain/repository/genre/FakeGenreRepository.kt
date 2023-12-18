/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.genre

import app.rockstar.common.core.Either
import app.rockstar.common.core.Either.Companion.asFailure
import app.rockstar.common.core.Either.Companion.asSuccess
import app.rockstar.domain.model.Genre
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGenreRepository : GenreRepository {

  var genres: ImmutableList<Genre> = persistentListOf(Item1, Item2, Item3)

  override suspend fun getGenreById(genreId: Long): Either<Genre, Throwable> = genres
    .find { genre -> genre.id == genreId }
    ?.asSuccess()
    ?: IllegalArgumentException("Genre cannot be found with genreId=$genreId").asFailure()

  override suspend fun getGenres(): ImmutableList<Genre> = genres

  override fun observeGenres(): Flow<ImmutableList<Genre>> = flowOf(genres)

  companion object {
    val Item1 = Genre(
      id = 201,
      name = "Rock",
      numberOfSongs = 200,
    )
    val Item2 = Genre(
      id = 202,
      name = "Pop",
      numberOfSongs = 150,
    )
    val Item3 = Genre(
      id = 203,
      name = "Hip Hop",
      numberOfSongs = 120,
    )
  }
}
