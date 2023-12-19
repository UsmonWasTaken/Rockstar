/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.songs.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import app.rockstar.android.R
import app.rockstar.android.databinding.FragmentSongsBinding
import app.rockstar.feature.songs.list.adapter.SongListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SongsFragment : Fragment(R.layout.fragment_songs) {

  private val viewModel: SongsViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentSongsBinding.bind(view)

    val songsListAdapter = SongListAdapter()
    binding.songsListView.adapter = songsListAdapter

    viewModel.songItemsStateFlow
      .flowWithLifecycle(viewLifecycleOwner.lifecycle)
      .onEach(songsListAdapter::submitList)
      .launchIn(viewLifecycleOwner.lifecycleScope)
  }
}
