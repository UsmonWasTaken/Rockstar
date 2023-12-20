/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.genres.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.rockstar.android.databinding.GridItemGenreBinding

internal class GenreListAdapter : ListAdapter<GenreListItem, GenreViewHolder>(GenreItemDiffer) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
    val binding = GridItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return GenreViewHolder(binding)
  }

  override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
    holder.onBindView(getItem(position))
  }
}
