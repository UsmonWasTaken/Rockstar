/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.albums.list.adapter

import android.net.Uri

internal data class AlbumListItem(
  val id: Long,
  val name: String,
  val artist: String,
  val coverUri: Uri,
  val onItemClicked: () -> Unit,
)
