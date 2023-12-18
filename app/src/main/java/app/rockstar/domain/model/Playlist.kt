/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.model

data class Playlist(
  val id: Long,
  val name: String,
  val numberOfSongs: Int,
)
