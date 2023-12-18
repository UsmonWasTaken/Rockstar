/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.model

data class Song(
  val id: Long,
  val name: String,
  val artistId: Long,
  val artist: String,
  val albumId: Long,
  val album: String,
  val albumArtist: String,
  val duration: Long,
  val dateAdded: Long,
  val dateModified: Long,
  val trackNumber: Int,
  val filePath: String,
)
