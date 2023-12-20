/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.albums.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import app.rockstar.android.R
import app.rockstar.android.databinding.FragmentAlbumsBinding
import app.rockstar.feature.albums.list.adapter.AlbumListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class AlbumsFragment : Fragment(R.layout.fragment_albums) {

  private val viewModel: AlbumsViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentAlbumsBinding.bind(view)

    val albumsListAdapter = AlbumListAdapter()
    binding.listView.adapter = albumsListAdapter

    viewModel.albumItemsStateFlow
      .flowWithLifecycle(viewLifecycleOwner.lifecycle)
      .onEach(albumsListAdapter::submitList)
      .launchIn(viewLifecycleOwner.lifecycleScope)
  }
}
