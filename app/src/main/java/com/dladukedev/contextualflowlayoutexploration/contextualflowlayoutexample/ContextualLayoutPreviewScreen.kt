package com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components.ConfigurationDialog
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components.ContextualFlowColumnExample
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components.ContextualFlowRowExample
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components.ContextualLayoutExampleScreenAppBar
import com.dladukedev.contextualflowlayoutexploration.shared.util.nextColor
import kotlin.random.Random

@Composable
fun ContextualLayoutPreviewScreen() {
  val state = contextualLayoutPreviewScreenState()

  Scaffold(
    topBar = { ContextualLayoutExampleScreenAppBar(onClickEditAction = state.toggleEditModalShown) },
  ) { innerPadding ->
    if (state.isEditModalShown) {
      ConfigurationDialog(state = state)
    }

    when (state.layoutType) {
      LayoutType.Row -> {
        ContextualFlowRowExample(
          state = state,
          modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(
              rememberScrollState()
            )
        )
      }

      LayoutType.Column -> {
        ContextualFlowColumnExample(
          state = state,
          modifier = Modifier
            .padding(innerPadding)
            .horizontalScroll(
              rememberScrollState()
            )
        )
      }
    }

  }
}

enum class LayoutType { Column, Row }
enum class Overflowtype { Visible, Clip, Expand, ExpandCollapse }

data class ContextualLayoutPreviewScreenState(
  val items: List<Color>,
  val maxLines: Int,
  val setMaxLines: (Int) -> Unit,
  val isEditModalShown: Boolean,
  val toggleEditModalShown: () -> Unit,
  val layoutType: LayoutType,
  val overflowtype: Overflowtype,
  val setLayoutType: (LayoutType) -> Unit,
  val setOverflowtype: (Overflowtype) -> Unit,
)

@Composable
fun contextualLayoutPreviewScreenState(): ContextualLayoutPreviewScreenState {
  val colors = remember {
    List(100) { Random.nextColor() }
  }

  var isEditModalShown by remember { mutableStateOf(false) }
  var maxLines by remember { mutableIntStateOf(2) }

  var layoutType by remember { mutableStateOf(LayoutType.Row) }
  var overflowtype by remember { mutableStateOf(Overflowtype.Clip) }

  return ContextualLayoutPreviewScreenState(
    items = colors,
    maxLines = maxLines,
    setMaxLines = { maxLines = it },
    isEditModalShown = isEditModalShown,
    toggleEditModalShown = { isEditModalShown = isEditModalShown.not() },
    layoutType = layoutType,
    overflowtype = overflowtype,
    setLayoutType = { layoutType = it },
    setOverflowtype = { overflowtype = it },
  )
}
