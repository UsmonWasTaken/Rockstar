/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.songs.list.adapter

import androidx.recyclerview.widget.DiffUtil

internal object SongItemDiffer : DiffUtil.ItemCallback<SongListItem>() {

  override fun areItemsTheSame(oldItem: SongListItem, newItem: SongListItem): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: SongListItem, newItem: SongListItem): Boolean {
    return oldItem.name == newItem.name &&
      oldItem.artist == newItem.artist &&
      oldItem.albumCoverUri == newItem.albumCoverUri
  }
}
