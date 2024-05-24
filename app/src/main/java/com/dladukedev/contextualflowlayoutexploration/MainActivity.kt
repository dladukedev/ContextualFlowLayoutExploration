package com.dladukedev.contextualflowlayoutexploration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.dladukedev.contextualflowlayoutexploration.contextualflowlayoutexample.ContextualLayoutPreviewScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MaterialTheme {
        ContextualLayoutPreviewScreen()
      }
    }
  }
}