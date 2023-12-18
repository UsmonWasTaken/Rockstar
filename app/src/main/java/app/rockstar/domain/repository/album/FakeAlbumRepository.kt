/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.album

import app.rockstar.common.core.Either
import app.rockstar.common.core.Either.Companion.asFailure
import app.rockstar.common.core.Either.Companion.asSuccess
import app.rockstar.domain.model.Album
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeAlbumRepository : AlbumRepository {

  var albums: ImmutableList<Album> = persistentListOf(Item1, Item2, Item3)

  override suspend fun getAlbumById(albumId: Long): Either<Album, Throwable> = albums
    .find { album -> album.id == albumId }
    ?.asSuccess()
    ?: IllegalArgumentException("Album cannot be found with albumId=$albumId").asFailure()

  override suspend fun getAlbums(): ImmutableList<Album> = albums

  override fun observeAlbums(): Flow<ImmutableList<Album>> = flowOf(albums)

  override suspend fun getAlbumsByArtist(artistId: Long): ImmutableList<Album> =
    albumsByArtist(artistId)

  override fun observeAlbumsByArtist(artistId: Long): Flow<ImmutableList<Album>> =
    flowOf(albumsByArtist(artistId))

  private fun albumsByArtist(artistId: Long): ImmutableList<Album> = albums
    .filter { album -> album.artistId == artistId }
    .toImmutableList()

  companion object {
    val Item1 = Album(
      id = 1,
      name = "Revolver",
      artistId = 101,
      artist = "The Beatles",
      albumArtist = "The Beatles",
      numberOfSongs = 14,
    )
    val Item2 = Album(
      id = 2,
      name = "The Wall",
      artistId = 102,
      artist = "Pink Floyd",
      albumArtist = "Pink Floyd",
      numberOfSongs = 26,
    )
    val Item3 = Album(
      id = 3,
      name = "Thriller",
      artistId = 103,
      artist = "Michael Jackson",
      albumArtist = "Michael Jackson",
      numberOfSongs = 30,
    )
  }
}
