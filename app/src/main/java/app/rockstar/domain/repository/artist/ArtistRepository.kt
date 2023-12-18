/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.domain.repository.artist

import app.rockstar.common.core.Either
import app.rockstar.domain.model.Artist
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface ArtistRepository {

  suspend fun getArtistById(artistId: Long): Either<Artist, Throwable>

  suspend fun getArtists(): ImmutableList<Artist>

  fun observeArtists(): Flow<ImmutableList<Artist>>
}
