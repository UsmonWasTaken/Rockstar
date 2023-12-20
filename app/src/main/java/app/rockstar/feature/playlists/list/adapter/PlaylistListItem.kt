/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.playlists.list.adapter

import android.net.Uri

internal data class PlaylistListItem(
  val id: Long,
  val name: String,
  val numberOfSongs: Int,
  val albumCoverUri: Uri,
  val onItemClicked: () -> Unit,
)
