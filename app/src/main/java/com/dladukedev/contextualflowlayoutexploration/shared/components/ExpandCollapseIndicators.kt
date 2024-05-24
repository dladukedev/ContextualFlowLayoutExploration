package com.dladukedev.contextualflowlayoutexploration.shared.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ContextualFlowColumnOverflowScope
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContextualFlowRowOverflowScope.ExpandIndicator(modifier: Modifier = Modifier) {
  ExpandIndicator(
    shownItemCount = shownItemCount,
    totalItemCount = totalItemCount,
    modifier = modifier,
  )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContextualFlowColumnOverflowScope.ExpandIndicator(modifier: Modifier = Modifier) {
  ExpandIndicator(
    shownItemCount = shownItemCount,
    totalItemCount = totalItemCount,
    modifier = modifier,
  )
}

@Composable
private fun ExpandIndicator(
  shownItemCount: Int,
  totalItemCount: Int,
  modifier: Modifier = Modifier,
) {
  Indicator(modifier = modifier) {
    Text("$shownItemCount Shown")
    Text("${totalItemCount - shownItemCount} Hidden")
    Text("Show More")
  }
}

@Composable
fun CollapseIndicator(
  modifier: Modifier = Modifier,
) {
  Indicator(modifier = modifier) {
    Text("Show Less")
  }
}

@Composable
private fun Indicator(
  modifier: Modifier = Modifier,
  content: @Composable ColumnScope.() -> Unit,
) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
      .clip(CircleShape)
      .border(1.dp, Color.Black, CircleShape)
      .size(128.dp),
  ) {
    content()
  }
}