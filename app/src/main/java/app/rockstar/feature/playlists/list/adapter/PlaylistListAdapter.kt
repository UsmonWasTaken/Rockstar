/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.playlists.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.rockstar.android.databinding.GridItemPlaylistBinding

internal class PlaylistListAdapter :
  ListAdapter<PlaylistListItem, PlaylistViewHolder>(PlaylistItemDiffer) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
    val binding = GridItemPlaylistBinding
      .inflate(LayoutInflater.from(parent.context), parent, false)
    return PlaylistViewHolder(binding)
  }

  override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
    holder.onBindView(getItem(position))
  }
}
