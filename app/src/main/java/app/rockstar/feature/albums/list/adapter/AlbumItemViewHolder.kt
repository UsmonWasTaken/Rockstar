/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.albums.list.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import app.rockstar.android.R
import app.rockstar.android.databinding.GridItemAlbumBinding

internal class AlbumItemViewHolder(
  private val binding: GridItemAlbumBinding,
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindView(album: AlbumListItem) = with(binding) {
    if (album.coverUri != Uri.EMPTY) albumCover.setImageURI(album.coverUri)
    else albumCover.setImageResource(R.drawable.default_album_cover)

    albumName.text = album.albumName
    albumArtist.text = album.albumArtist

    root.setOnClickListener { album.onItemClicked() }
  }
}
