/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.genres.list.adapter

import androidx.recyclerview.widget.DiffUtil

internal object GenreItemDiffer : DiffUtil.ItemCallback<GenreListItem>() {

  override fun areItemsTheSame(oldItem: GenreListItem, newItem: GenreListItem): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: GenreListItem, newItem: GenreListItem): Boolean {
    return oldItem.name == newItem.name &&
      oldItem.songCount == newItem.songCount &&
      oldItem.albumCoverPreviewUri == newItem.albumCoverPreviewUri
  }
}
