/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.artists.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import app.rockstar.android.R
import app.rockstar.android.databinding.FragmentArtistsBinding
import app.rockstar.feature.artists.list.adapter.ArtistListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ArtistsFragment : Fragment(R.layout.fragment_artists) {

  private val viewModel: ArtistViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentArtistsBinding.bind(view)

    val artistListAdapter = ArtistListAdapter()
    binding.listView.adapter = artistListAdapter

    viewModel.artistItemsStateFlow
      .flowWithLifecycle(viewLifecycleOwner.lifecycle)
      .onEach(artistListAdapter::submitList)
      .launchIn(viewLifecycleOwner.lifecycleScope)
  }
}
