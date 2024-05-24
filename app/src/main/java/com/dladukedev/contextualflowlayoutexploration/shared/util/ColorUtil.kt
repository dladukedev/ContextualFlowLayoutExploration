package com.dladukedev.contextualflowlayoutexploration.shared.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlin.random.Random

fun Random.nextColor(): Color {
  val red = nextInt(256)
  val green = nextInt(256)
  val blue = nextInt(256)

  return Color(red, green, blue)
}

@OptIn(ExperimentalStdlibApi::class)
val Color.hexString: String
  get() {
    return "#${this.toArgb().toHexString().drop(2)}"
  }
