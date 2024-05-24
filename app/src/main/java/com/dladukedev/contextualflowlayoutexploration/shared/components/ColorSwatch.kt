package com.dladukedev.contextualflowlayoutexploration.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dladukedev.contextualflowlayoutexploration.shared.util.hexString

@Composable
fun ColorSwatch(color: Color, modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .clip(CircleShape)
      .background(color)
      .size(128.dp),
    contentAlignment = Alignment.Center,
  ) {
    Text(text = color.hexString,
      modifier = Modifier
        .clip(RoundedCornerShape(percent = 50))
        .background(Color.White.copy(alpha = 0.6f))
        .padding(8.dp)
    )
  }
}
