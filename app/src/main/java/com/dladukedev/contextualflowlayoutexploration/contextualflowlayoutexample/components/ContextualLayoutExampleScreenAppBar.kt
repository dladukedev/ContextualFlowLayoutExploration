package com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContextualLayoutExampleScreenAppBar(onClickEditAction: () -> Unit) {
  TopAppBar(title = { Text("Contextual Flow Layout") }, actions = {
    IconButton(onClick = onClickEditAction) {
      Icon(imageVector = Icons.Outlined.Edit, contentDescription = "Edit View")
    }
  })
}