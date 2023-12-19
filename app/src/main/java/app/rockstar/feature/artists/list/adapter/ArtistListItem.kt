/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.feature.artists.list.adapter

import android.net.Uri

internal class ArtistListItem(
  val id: Long,
  val artistImage: Uri,
  val artistName: String,
  val onItemClicked: () -> Unit,
) {

  override fun equals(other: Any?): Boolean = this === other ||
    (javaClass == other?.javaClass &&
      other is ArtistListItem &&
      id == other.id &&
      artistImage == other.artistImage &&
      artistName == other.artistName)

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + artistImage.hashCode()
    return 31 * result + artistName.hashCode()
  }

  override fun toString(): String =
    "ArtistListItem(id=$id, artistImage=$artistImage, artistName='$artistName')"
}
