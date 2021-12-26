package com.github.statuscolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.github.statuscolor.ui.theme.Purple500
import com.github.statuscolor.ui.theme.StatusColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusColorTheme {
                val current = remember {
                    mutableStateOf(false)
                }
                window.statusBarColor = if (current.value) {Color.Red.toArgb()} else {Purple500.toArgb()}
                window.navigationBarColor = if (current.value) {Color.Red.toArgb()} else {Purple500.toArgb()}
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Box(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = 10.0.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Button(
                                modifier = Modifier.padding(10.0.dp),
                                onClick = {
                                    current.value = !current.value
                            }) {
                                val text = if (current.value) { "Restore" } else { "Change" }
                                Text(text)
                            }
                        }
                    }
                }
            }
        }
    }
}

