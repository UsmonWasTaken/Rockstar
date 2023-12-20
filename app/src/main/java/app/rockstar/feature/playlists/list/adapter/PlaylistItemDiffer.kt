/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.playlists.list.adapter

import androidx.recyclerview.widget.DiffUtil

internal object PlaylistItemDiffer : DiffUtil.ItemCallback<PlaylistListItem>() {

  override fun areItemsTheSame(oldItem: PlaylistListItem, newItem: PlaylistListItem): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: PlaylistListItem, newItem: PlaylistListItem): Boolean {
    return oldItem.name == newItem.name &&
      oldItem.numberOfSongs == newItem.numberOfSongs &&
      oldItem.albumCoverUri == newItem.albumCoverUri
  }
}
