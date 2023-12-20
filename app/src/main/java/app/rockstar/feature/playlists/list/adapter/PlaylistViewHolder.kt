/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.playlists.list.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import app.rockstar.android.R
import app.rockstar.android.databinding.GridItemPlaylistBinding

internal class PlaylistViewHolder(
  private val binding: GridItemPlaylistBinding,
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindView(playlist: PlaylistListItem) = with(binding) {
    name.text = playlist.name
    numberOfSongs.text = numberOfSongs.resources.getQuantityString(
      R.plurals.number_of_songs,
      playlist.numberOfSongs,
      playlist.numberOfSongs,
    )

    if (playlist.albumCoverUri != Uri.EMPTY) {
      albumCover.setImageURI(playlist.albumCoverUri)
      // TODO: Set background and text colors based on album cover
    } else {
      // TODO: Set default genre preview image
    }

    root.setOnClickListener { playlist.onItemClicked() }
  }
}
