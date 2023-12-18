/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.playlist

import app.rockstar.common.core.Either
import app.rockstar.domain.model.Playlist
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {

  suspend fun getPlaylistById(playlistId: Long): Either<Playlist, Throwable>

  suspend fun getPlaylists(): ImmutableList<Playlist>

  fun observePlaylists(): Flow<ImmutableList<Playlist>>
}
