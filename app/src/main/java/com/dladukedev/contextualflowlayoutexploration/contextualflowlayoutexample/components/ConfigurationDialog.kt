package com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.ContextualLayoutPreviewScreenState
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.LayoutType
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.Overflowtype

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigurationDialog(state: ContextualLayoutPreviewScreenState) {
  BasicAlertDialog(onDismissRequest = state.toggleEditModalShown) {
    Surface(
      shape = MaterialTheme.shapes.large,
      tonalElevation = AlertDialogDefaults.TonalElevation
    ) {
      Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(text = "Settings", modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Layout Type", modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.labelMedium)
        RadioItem(
          isSelected = state.layoutType == LayoutType.Row,
          label = "Row",
          onSelect = { state.setLayoutType(LayoutType.Row) })
        RadioItem(
          isSelected = state.layoutType == LayoutType.Column,
          label = "Column",
          onSelect = { state.setLayoutType(LayoutType.Column) })
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Overflow Type", modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.labelMedium)
        RadioItem(
          isSelected = state.overflowtype == Overflowtype.Clip,
          label = "Clip",
          onSelect = { state.setOverflowtype(Overflowtype.Clip) })
        RadioItem(
          isSelected = state.overflowtype == Overflowtype.Visible,
          label = "Visible",
          onSelect = { state.setOverflowtype(Overflowtype.Visible) })
        RadioItem(
          isSelected = state.overflowtype == Overflowtype.Expand,
          label = "Expand",
          onSelect = { state.setOverflowtype(Overflowtype.Expand) })
        RadioItem(
          isSelected = state.overflowtype == Overflowtype.ExpandCollapse,
          label = "Expand/Collapse",
          onSelect = { state.setOverflowtype(Overflowtype.ExpandCollapse) })
      }
    }
  }
}

@Composable
private fun RadioItem(
  isSelected: Boolean,
  label: String,
  onSelect: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .selectable(
        selected = isSelected,
        onClick = onSelect,
        role = Role.RadioButton
      )
      .padding(horizontal = 16.dp, vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    RadioButton(
      selected = isSelected, onClick = null
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(
      text = label, style = MaterialTheme.typography.bodyMedium
    )
  }
}