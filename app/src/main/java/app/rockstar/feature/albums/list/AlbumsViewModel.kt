/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.albums.list

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rockstar.domain.model.Album
import app.rockstar.domain.repository.album.AlbumRepository
import app.rockstar.feature.albums.list.adapter.AlbumListItem
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
internal class AlbumsViewModel @Inject constructor(
  albumRepository: AlbumRepository,
) : ViewModel() {

  val albumItemsStateFlow: StateFlow<ImmutableList<AlbumListItem>> = albumRepository
    .observeAlbums()
    .map(::mapToListItems)
    .stateIn(viewModelScope, WhileSubscribed(5_000), persistentListOf())

  private fun mapToListItems(albums: ImmutableList<Album>) = albums.map { album ->
    AlbumListItem(
      id = album.id,
      coverUri = Uri.EMPTY,
      albumName = album.name,
      albumArtist = album.albumArtist,
      onItemClicked = {
        logcat { "$album has just clicked." }
      },
    )
  }.toImmutableList()
}
