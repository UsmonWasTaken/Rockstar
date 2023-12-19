/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.artists.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.rockstar.android.databinding.GridItemArtistBinding

internal class ArtistListAdapter : ListAdapter<ArtistListItem, ArtistViewHolder>(ArtistItemDiffer) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
    val binding = GridItemArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ArtistViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
    holder.onBindView(getItem(position))
  }
}
