/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.songs.list

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rockstar.domain.model.Song
import app.rockstar.domain.repository.song.SongRepository
import app.rockstar.feature.songs.list.adapter.SongListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import logcat.logcat

@HiltViewModel
internal class SongsViewModel @Inject constructor(
  songRepository: SongRepository,
) : ViewModel() {

  val songItemsStateFlow = songRepository
    .observeSongs()
    .map(::mapToListItems)
    .stateIn(viewModelScope, WhileSubscribed(5_000), persistentListOf())

  private fun mapToListItems(songs: List<Song>) = songs.map { song ->
    SongListItem(
      id = song.id,
      name = song.name,
      artist = song.artist,
      albumCoverUri = Uri.EMPTY,
      onItemClicked = {
        logcat { "$song item is clicked" }
      },
    )
  }.toImmutableList()
}
