/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package app.rockstar.android

import android.app.Application
import logcat.AndroidLogcatLogger

class RockstarApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    AndroidLogcatLogger.installOnDebuggableApp(this)
  }
}
