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
    songCount.text = songCount.resources.getString(R.string.n_songs, genre.songCount)

    if (genre.albumCoverPreviewUri != Uri.EMPTY) {
      albumCoverPreview.setImageURI(genre.albumCoverPreviewUri)
    } else {
      // TODO: Set default genre preview image
    }

    root.setOnClickListener { genre.onItemClicked() }
  }
}
