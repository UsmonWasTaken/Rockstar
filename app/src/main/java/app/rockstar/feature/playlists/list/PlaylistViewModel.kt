/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.playlists.list

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rockstar.domain.model.Playlist
import app.rockstar.domain.repository.playlist.PlaylistRepository
import app.rockstar.feature.playlists.list.adapter.PlaylistListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import logcat.logcat

@HiltViewModel
internal class PlaylistViewModel @Inject constructor(
  playlistRepository: PlaylistRepository,
) : ViewModel() {

  val playlistItemsStateFlow: StateFlow<ImmutableList<PlaylistListItem>> = playlistRepository
    .observePlaylists()
    .map(::mapToListItems)
    .stateIn(viewModelScope, WhileSubscribed(5_000), persistentListOf())

  private fun mapToListItems(playlists: List<Playlist>) = playlists.map { playlist ->
    PlaylistListItem(
      id = playlist.id,
      name = playlist.name,
      numberOfSongs = playlist.numberOfSongs,
      albumCoverUri = Uri.EMPTY,
      onItemClicked = {
        logcat { "$playlist item is clicked" }
      },
    )
  }.toImmutableList()
}
