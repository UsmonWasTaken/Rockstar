/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.songs.list.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import app.rockstar.android.R
import app.rockstar.android.databinding.ListItemSongBinding

internal class SongViewHolder(
  private val binding: ListItemSongBinding,
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindView(song: SongListItem) = with(binding) {
    name.text = song.name
    artist.text = song.artist

    if (song.albumCoverUri != Uri.EMPTY) {
      albumCover.setImageURI(song.albumCoverUri)
    } else {
      albumCover.setImageResource(R.drawable.default_audio_cover)
    }

    // TODO: Configure popup menu here

    root.setOnClickListener { song.onItemClicked() }
  }
}
