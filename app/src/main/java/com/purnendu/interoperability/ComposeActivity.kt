package com.purnendu.interoperability

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.purnendu.interoperability.ui.theme.InteroperabilityTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteroperabilityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AndroidView(
                        factory = {
                            TextView(it)
                        }
                    ) { textView ->
                        textView.apply {
                            text = "This is an XML view in a composable"
                            setTextColor(Color.BLACK)
                            textSize = 20f
                            gravity = Gravity.CENTER
                        }
                    }
                }
            }
        }
    }
}
