package com.groot.listrestorestateexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.groot.listrestorestateexample.navigation.NavHostController
import com.groot.listrestorestateexample.ui.theme.ListRestoreStateExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListRestoreStateExampleTheme {
                NavHostController(navController = rememberNavController())
            }
        }
    }
}

