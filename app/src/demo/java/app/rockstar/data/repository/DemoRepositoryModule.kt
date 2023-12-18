/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.data.repository

import app.rockstar.domain.repository.album.AlbumRepository
import app.rockstar.domain.repository.album.FakeAlbumRepository
import app.rockstar.domain.repository.artist.ArtistRepository
import app.rockstar.domain.repository.artist.FakeArtistRepository
import app.rockstar.domain.repository.genre.FakeGenreRepository
import app.rockstar.domain.repository.genre.GenreRepository
import app.rockstar.domain.repository.playlist.FakePlaylistRepository
import app.rockstar.domain.repository.playlist.PlaylistRepository
import app.rockstar.domain.repository.song.FakeSongRepository
import app.rockstar.domain.repository.song.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DemoRepositoryModule {

  @Provides
  @Singleton
  fun provideAlbumRepository(): AlbumRepository = FakeAlbumRepository()

  @Provides
  @Singleton
  fun provideArtistRepository(): ArtistRepository = FakeArtistRepository()

  @Provides
  @Singleton
  fun provideGenreRepository(): GenreRepository = FakeGenreRepository()

  @Provides
  @Singleton
  fun providePlaylistRepository(): PlaylistRepository = FakePlaylistRepository()

  @Provides
  @Singleton
  fun provideSongRepository(): SongRepository = FakeSongRepository()
}
