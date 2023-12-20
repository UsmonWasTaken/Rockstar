/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.genres.list.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import app.rockstar.android.R
import app.rockstar.android.databinding.GridItemGenreBinding

internal class GenreViewHolder(
  private val binding: GridItemGenreBinding,
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindView(genre: GenreListItem) = with(binding) {
    name.text = genre.name
    songCount.text = songCount.resources.getQuantityString(
      R.plurals.number_of_songs,
      genre.numberOfSongs,
      genre.numberOfSongs,
    )

    if (genre.albumCoverUri != Uri.EMPTY) {
      albumCover.setImageURI(genre.albumCoverUri)
      // TODO: Set background and text colors based on album cover
    } else {
      // TODO: Set default genre preview image
    }

    root.setOnClickListener { genre.onItemClicked() }
  }
}
