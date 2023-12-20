/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.genres.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import app.rockstar.android.R
import app.rockstar.android.databinding.FragmentGenresBinding
import app.rockstar.feature.genres.list.adapter.GenreListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class GenresFragment : Fragment(R.layout.fragment_genres) {

  private val viewModel: GenresViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentGenresBinding.bind(view)

    val genreListAdapter = GenreListAdapter()
    binding.listView.adapter = genreListAdapter

    viewModel.genreItemsStateFlow
      .flowWithLifecycle(viewLifecycleOwner.lifecycle)
      .onEach(genreListAdapter::submitList)
      .launchIn(viewLifecycleOwner.lifecycleScope)
  }
}
