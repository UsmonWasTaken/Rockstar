/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.album

import app.rockstar.common.core.Either
import app.rockstar.domain.model.Album
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

  suspend fun getAlbumById(albumId: Long): Either<Album, Throwable>

  suspend fun getAlbums(): ImmutableList<Album>

  fun observeAlbums(): Flow<ImmutableList<Album>>

  suspend fun getAlbumsByArtist(artistId: Long): ImmutableList<Album>

  fun observeAlbumsByArtist(artistId: Long): Flow<ImmutableList<Album>>
}
