/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.artists.list.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import app.rockstar.android.R
import app.rockstar.android.databinding.GridItemArtistBinding

internal class ArtistViewHolder(
  private val binding: GridItemArtistBinding,
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindView(artist: ArtistListItem) = with(binding) {
    name.text = artist.name

    if (artist.imageUri != Uri.EMPTY) {
      image.setImageURI(artist.imageUri)
    } else {
      image.setImageResource(R.drawable.default_artist_image)
    }

    root.setOnClickListener { artist.onItemClicked() }
  }
}
