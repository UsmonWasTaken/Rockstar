/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.artists.list

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rockstar.domain.model.Artist
import app.rockstar.domain.repository.artist.ArtistRepository
import app.rockstar.feature.artists.list.adapter.ArtistListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import logcat.logcat

@HiltViewModel
internal class ArtistViewModel @Inject constructor(
  artistRepository: ArtistRepository,
) : ViewModel() {

  val artistItemsStateFlow: StateFlow<ImmutableList<ArtistListItem>> = artistRepository
    .observeArtists()
    .map(::mapToListItems)
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), persistentListOf())

  private fun mapToListItems(artists: List<Artist>) = artists.map { artist ->
    ArtistListItem(
      id = artist.id,
      artistImage = Uri.EMPTY,
      artistName = artist.name,
      onItemClicked = {
        logcat { "$artist has just clicked." }
      },
    )
  }.toImmutableList()
}
