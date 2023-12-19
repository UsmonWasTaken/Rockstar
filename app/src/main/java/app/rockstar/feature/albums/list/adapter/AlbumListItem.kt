/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.albums.list.adapter

import android.net.Uri

internal class AlbumListItem(
  val id: Long,
  val coverUri: Uri,
  val albumName: String,
  val albumArtist: String,
  val onItemClicked: () -> Unit,
) {

  override fun equals(other: Any?): Boolean = this === other ||
    (javaClass == other?.javaClass &&
      other is AlbumListItem &&
      id == other.id &&
      coverUri == other.coverUri &&
      albumName == other.albumName &&
      albumArtist == other.albumArtist)

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + coverUri.hashCode()
    result = 31 * result + albumName.hashCode()
    return 31 * result + albumArtist.hashCode()
  }

  override fun toString(): String =
    "AlbumListItem(id=$id, coverUri=$coverUri, albumName='$albumName', albumArtist='$albumArtist')"
}
