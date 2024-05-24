package com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ContextualFlowColumn
import androidx.compose.foundation.layout.ContextualFlowColumnOverflow
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.ContextualLayoutPreviewScreenState
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.Overflowtype
import com.dladukedev.contextualflowlayoutexploration.shared.components.CollapseIndicator
import com.dladukedev.contextualflowlayoutexploration.shared.components.ColorSwatch
import com.dladukedev.contextualflowlayoutexploration.shared.components.ExpandIndicator

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContextualFlowRowExample(state: ContextualLayoutPreviewScreenState, modifier: Modifier = Modifier) {
  val overflow = when (state.overflowtype) {
    Overflowtype.Visible -> ContextualFlowRowOverflow.Visible
    Overflowtype.Clip -> ContextualFlowRowOverflow.Clip
    Overflowtype.Expand -> ContextualFlowRowOverflow.expandIndicator { ExpandIndicator(modifier = Modifier.clickable { state.setMaxLines(state.maxLines + 1) }) }
    Overflowtype.ExpandCollapse -> ContextualFlowRowOverflow.expandOrCollapseIndicator(
      expandIndicator = { ExpandIndicator(modifier = Modifier.clickable { state.setMaxLines(Int.MAX_VALUE) }) },
      collapseIndicator = { CollapseIndicator(modifier = Modifier.clickable { state.setMaxLines(2) }) },
    )
  }

  ContextualFlowRow(
    itemCount = state.items.size,
    maxLines = state.maxLines,
    overflow = overflow,
    modifier = modifier,
  ) { index ->
    ColorSwatch(color = state.items[index])
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContextualFlowColumnExample(state: ContextualLayoutPreviewScreenState, modifier: Modifier = Modifier) {
  val overflow = when (state.overflowtype) {
    Overflowtype.Visible -> ContextualFlowColumnOverflow.Visible
    Overflowtype.Clip -> ContextualFlowColumnOverflow.Clip
    Overflowtype.Expand -> ContextualFlowColumnOverflow.expandIndicator { ExpandIndicator(modifier = Modifier.clickable { state.setMaxLines(state.maxLines + 1) }) }
    Overflowtype.ExpandCollapse -> ContextualFlowColumnOverflow.expandOrCollapseIndicator(
      expandIndicator = { ExpandIndicator(modifier = Modifier.clickable { state.setMaxLines(Int.MAX_VALUE) }) },
      collapseIndicator = { CollapseIndicator(modifier = Modifier.clickable { state.setMaxLines(2) }) },
    )
  }

  ContextualFlowColumn(
    itemCount = state.items.size,
    maxLines = state.maxLines,
    overflow = overflow,
    modifier = modifier,
  ) { index ->
    ColorSwatch(color = state.items[index])
  }
}
