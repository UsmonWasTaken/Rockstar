/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.song

import app.rockstar.common.core.Either
import app.rockstar.domain.model.Song
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface SongRepository {

  suspend fun getSongById(songId: Long): Either<Song, Throwable>

  suspend fun getSongs(): ImmutableList<Song>

  fun observeSongs(): Flow<ImmutableList<Song>>

  suspend fun getSongsByAlbum(albumId: Long): ImmutableList<Song>

  fun observeSongsByAlbum(albumId: Long): Flow<ImmutableList<Song>>

  suspend fun getSongsByArtist(artistId: Long): ImmutableList<Song>

  fun observeSongsByArtist(artistId: Long): Flow<ImmutableList<Song>>
}
