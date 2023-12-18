/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import app.rockstar.android.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    installSplashScreen()

    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHost
    navController = navHost.navController

    val topLevelDestinations = setOf(
      R.id.fragment_for_you,
      R.id.fragment_songs,
      R.id.fragment_albums,
      R.id.fragment_artists,
      R.id.fragment_playlists,
    )
    configureBottomNavigationView(binding.bottomNavigationView, topLevelDestinations)
  }

  private fun configureBottomNavigationView(
    navigationView: BottomNavigationView,
    topLevelDestinations: Set<Int>,
  ) {
    navigationView.setupWithNavController(navController)
    navController.addOnDestinationChangedListener { _, destination, _ ->
      navigationView.isVisible = destination.id in topLevelDestinations
    }
  }

  override fun onNavigateUp(): Boolean {
    return navController.navigateUp() || super.onNavigateUp()
  }
}
