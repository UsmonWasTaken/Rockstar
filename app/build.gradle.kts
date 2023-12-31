/*
 * Copyright (c) 2023 The Rockstar authors and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
  alias(libs.plugins.hilt)
}

android {
  namespace = "app.rockstar.android"
  compileSdk = 34

  defaultConfig {
    applicationId = "app.rockstar.android"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    vectorDrawables {
      useSupportLibrary = true
    }

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  productFlavors {
    flavorDimensions.add("contentType")

    register("demo") {
      dimension = "contentType"
      applicationIdSuffix = ".demo"
      versionNameSuffix = "-dev"
    }

    register("prod") {
      dimension = "contentType"
    }
  }

  buildFeatures {
    viewBinding = true
  }

  compileOptions {
    isCoreLibraryDesugaringEnabled = true
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  coreLibraryDesugaring(libs.android.desugarJdkLibs)

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.splashScreen)

  implementation(libs.androidx.navigation.ui)
  implementation(libs.androidx.navigation.fragment)
  implementation(libs.androidx.navigation.runtime)

  implementation(libs.google.material)
  implementation(libs.google.hilt.android)
  ksp(libs.google.hilt.compiler)

  implementation(libs.kotlinx.collections.immutable)

  implementation(libs.squareup.logcat)
}
