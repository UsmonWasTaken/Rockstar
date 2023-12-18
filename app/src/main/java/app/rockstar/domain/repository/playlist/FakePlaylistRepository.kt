/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.playlist

import app.rockstar.common.core.Either
import app.rockstar.common.core.Either.Companion.asFailure
import app.rockstar.common.core.Either.Companion.asSuccess
import app.rockstar.domain.model.Playlist
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakePlaylistRepository : PlaylistRepository {

  var playlists: ImmutableList<Playlist> = persistentListOf(Item1, Item2, Item3)

  override suspend fun getPlaylistById(playlistId: Long): Either<Playlist, Throwable> = playlists
    .find { playlist -> playlist.id == playlistId }
    ?.asSuccess()
    ?: IllegalArgumentException("Playlist cannot be found with playlistId=$playlistId").asFailure()

  override suspend fun getPlaylists(): ImmutableList<Playlist> = playlists

  override fun observePlaylists(): Flow<ImmutableList<Playlist>> = flowOf(playlists)

  companion object {
    val Item1 = Playlist(
      id = 301,
      name = "Chill Vibes",
      numberOfSongs = 25,
    )
    val Item2 = Playlist(
      id = 302,
      name = "Workout Mix",
      numberOfSongs = 30,
    )
    val Item3 = Playlist(
      id = 303,
      name = "Road Trip Jams",
      numberOfSongs = 20,
    )
  }
}
