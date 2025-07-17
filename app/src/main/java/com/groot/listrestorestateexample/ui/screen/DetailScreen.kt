package com.groot.listrestorestateexample.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.groot.listrestorestateexample.navigation.NavDest
import com.groot.listrestorestateexample.navigation.navigate

@Composable
fun DetailScreen(navController: NavHostController) {

    BackHandler {
        navigate(navController, null, NavDest.detailScreen, NavDest.listScreen, true)
    }
}