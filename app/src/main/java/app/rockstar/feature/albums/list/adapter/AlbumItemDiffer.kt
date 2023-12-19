/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.albums.list.adapter

import androidx.recyclerview.widget.DiffUtil

internal object AlbumItemDiffer : DiffUtil.ItemCallback<AlbumListItem>() {

  override fun areItemsTheSame(oldItem: AlbumListItem, newItem: AlbumListItem): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: AlbumListItem, newItem: AlbumListItem): Boolean {
    return oldItem.coverUri == newItem.coverUri &&
      oldItem.albumName == newItem.albumName &&
      oldItem.albumArtist == newItem.albumArtist
  }
}
