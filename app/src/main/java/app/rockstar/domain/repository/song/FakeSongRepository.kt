/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.song

import app.rockstar.common.core.Either
import app.rockstar.common.core.Either.Companion.asFailure
import app.rockstar.common.core.Either.Companion.asSuccess
import app.rockstar.domain.model.Song
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSongRepository : SongRepository {

  var songs: ImmutableList<Song> = persistentListOf(Item1, Item2, Item3)

  override suspend fun getSongById(songId: Long): Either<Song, Throwable> = songs
    .find { song -> song.id == songId }
    ?.asSuccess()
    ?: IllegalArgumentException("Song cannot be found with songId=$songId").asFailure()

  override suspend fun getSongs(): ImmutableList<Song> = songs

  override fun observeSongs(): Flow<ImmutableList<Song>> = flowOf(songs)

  override suspend fun getSongsByAlbum(albumId: Long): ImmutableList<Song> =
    songsByAlbum(albumId)

  override fun observeSongsByAlbum(albumId: Long): Flow<ImmutableList<Song>> =
    flowOf(songsByAlbum(albumId))

  private fun songsByAlbum(albumId: Long): ImmutableList<Song> = songs
    .filter { song -> song.albumId == albumId }
    .toImmutableList()

  override suspend fun getSongsByArtist(artistId: Long): ImmutableList<Song> =
    songsByArtist(artistId)

  override fun observeSongsByArtist(artistId: Long): Flow<ImmutableList<Song>> =
    flowOf(songsByArtist(artistId))

  private fun songsByArtist(artistId: Long): ImmutableList<Song> = songs
    .filter { song -> song.artistId == artistId }
    .toImmutableList()

  companion object {
    val Item1 = Song(
      id = 401,
      name = "Love You To",
      artistId = 101,
      artist = "The Beatles",
      albumId = 1,
      album = "Revolver",
      albumArtist = "The Beatles",
      duration = 185_400, // 03:09
      dateAdded = System.currentTimeMillis(),
      dateModified = System.currentTimeMillis(),
      trackNumber = 4,
      filePath = "/Music/TheBeatles/LoveYouTo.mp3",
    )
    val Item2 = Song(
      id = 402,
      name = "Run Like Hell",
      artistId = 102,
      artist = "Pink Floyd",
      albumId = 2,
      album = "The Wall",
      albumArtist = "Pink Floyd",
      duration = 260_000, // 04:20
      dateAdded = System.currentTimeMillis(),
      dateModified = System.currentTimeMillis(),
      trackNumber = 22,
      filePath = "/Music/RunLikeHell.mp3",
    )
    val Item3 = Song(
      id = 403,
      name = "Thriller",
      artistId = 103,
      artist = "Michael Jackson",
      albumId = 3,
      album = "Thriller",
      albumArtist = "Michael Jackson",
      duration = 357_000, // 5:57
      dateAdded = System.currentTimeMillis(),
      dateModified = System.currentTimeMillis(),
      trackNumber = 7,
      filePath = "/Music/Thriller.mp3",
    )
  }
}
