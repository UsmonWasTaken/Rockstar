/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.songs.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.rockstar.android.databinding.ListItemSongBinding

internal class SongListAdapter : ListAdapter<SongListItem, SongViewHolder>(SongItemDiffer) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
    val binding = ListItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return SongViewHolder(binding)
  }

  override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
    holder.onBindView(getItem(position))
  }
}
