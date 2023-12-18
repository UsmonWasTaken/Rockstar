/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.artist

import app.rockstar.common.core.Either
import app.rockstar.common.core.Either.Companion.asFailure
import app.rockstar.common.core.Either.Companion.asSuccess
import app.rockstar.domain.model.Artist
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeArtistRepository : ArtistRepository {

  var artists: ImmutableList<Artist> = persistentListOf(Item1, Item2, Item3)

  override suspend fun getArtistById(artistId: Long): Either<Artist, Throwable> = artists
    .find { artist -> artist.id == artistId }
    ?.asSuccess()
    ?: IllegalArgumentException("Artist cannot be found with artistId=$artistId").asFailure()

  override suspend fun getArtists(): ImmutableList<Artist> = artists

  override fun observeArtists(): Flow<ImmutableList<Artist>> = flowOf(artists)

  companion object {
    val Item1 = Artist(
      id = 101,
      name = "The Beatles",
      numberOfSongs = 150,
    )
    val Item2 = Artist(
      id = 102,
      name = "Pink Floyd",
      numberOfSongs = 100,
    )
    val Item3 = Artist(
      id = 103,
      name = "Michael Jackson",
      numberOfSongs = 80,
    )
  }
}
