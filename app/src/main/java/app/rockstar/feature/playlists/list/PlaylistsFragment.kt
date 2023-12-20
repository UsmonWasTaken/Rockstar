/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.playlists.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import app.rockstar.android.R
import app.rockstar.android.databinding.FragmentPlaylistsBinding
import app.rockstar.feature.playlists.list.adapter.PlaylistListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PlaylistsFragment : Fragment(R.layout.fragment_playlists) {

  private val viewModel: PlaylistViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentPlaylistsBinding.bind(view)

    val playlistListAdapter = PlaylistListAdapter()
    binding.listView.adapter = playlistListAdapter

    viewModel.playlistItemsStateFlow
      .flowWithLifecycle(viewLifecycleOwner.lifecycle)
      .onEach(playlistListAdapter::submitList)
      .launchIn(viewLifecycleOwner.lifecycleScope)
  }
}
