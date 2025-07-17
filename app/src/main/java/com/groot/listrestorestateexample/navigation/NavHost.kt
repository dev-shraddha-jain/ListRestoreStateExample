package com.groot.listrestorestateexample.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.groot.listrestorestateexample.ui.screen.DetailScreen
import com.groot.listrestorestateexample.ui.screen.ListScreen
import com.groot.listrestorestateexample.vm.ScrollPositionViewModel

object NavDest {

    val detailScreen = "detailScreen"
    val listScreen = "listScreen"
}


@Composable
fun NavHostController(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavDest.listScreen) {
        /* ************************************************************ authentication ************************************************************ */
        composable(NavDest.listScreen) {
            val scrollVm: ScrollPositionViewModel = viewModel(it) //so as to vm do not re-instatates
            ListScreen(navController, scrollVm)
        }

        composable(NavDest.detailScreen) {
            DetailScreen(navController)
        }
    }
}

fun <T> navigate(navController: NavController, o: T?, from: String, destination: String, navRestoreState: Boolean = false) {
    if (navRestoreState) {
        navController.popBackStack(destination, false)
    } else {
        navController.navigate(destination) {
            launchSingleTop = true  // Prevent multiple copies of  screen
        }
    }

}