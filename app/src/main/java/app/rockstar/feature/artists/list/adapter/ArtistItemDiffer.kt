/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.artists.list.adapter

import androidx.recyclerview.widget.DiffUtil

internal object ArtistItemDiffer : DiffUtil.ItemCallback<ArtistListItem>() {

  override fun areItemsTheSame(oldItem: ArtistListItem, newItem: ArtistListItem): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: ArtistListItem, newItem: ArtistListItem): Boolean {
    return oldItem.artistImageUri == newItem.artistImageUri &&
      oldItem.artistName == newItem.artistName
  }
}
