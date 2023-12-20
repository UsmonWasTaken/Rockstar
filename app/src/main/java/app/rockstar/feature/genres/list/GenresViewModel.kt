/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.genres.list

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rockstar.domain.model.Genre
import app.rockstar.domain.repository.genre.GenreRepository
import app.rockstar.feature.genres.list.adapter.GenreListItem
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
internal class GenresViewModel @Inject constructor(
  genreRepository: GenreRepository,
) : ViewModel() {

  val genreItemsStateFlow: StateFlow<ImmutableList<GenreListItem>> = genreRepository
    .observeGenres()
    .map(::mapToListItems)
    .stateIn(viewModelScope, WhileSubscribed(5_000), persistentListOf())

  private fun mapToListItems(genres: List<Genre>) = genres.map { genre ->
    GenreListItem(
      id = genre.id,
      name = genre.name,
      numberOfSongs = genre.numberOfSongs,
      albumCoverUri = Uri.EMPTY,
      onItemClicked = {
        logcat { "$genre item is clicked" }
      },
    )
  }.toImmutableList()
}
