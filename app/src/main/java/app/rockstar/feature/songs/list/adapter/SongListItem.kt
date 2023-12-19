/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.songs.list.adapter

import android.net.Uri

internal data class SongListItem(
  val id: Long,
  val name: String,
  val artist: String,
  val albumCoverUri: Uri,
  val onItemClicked: () -> Unit,
)
