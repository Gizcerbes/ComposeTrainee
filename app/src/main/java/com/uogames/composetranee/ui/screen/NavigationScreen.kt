package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object NavigationScreen {
	private data class Destination(
		val route: String,
		val routeWithParams: String = route
	)

	private val navigator = Destination(route = "navigator")
	private val first = Destination(route = "first")
	private val second = Destination(route = "second")
	private val third = Destination(route = "third")


	@Composable
	fun Show() {
		val navController = rememberNavController()
		NavHost(navController = navController, startDestination = navigator.route) {
			composable(navigator.route) {
				Buttons(navController = navController)
			}
			composable(first.route) {
				FirstScreen.Show()
			}
			composable(second.route) {
				SecondScreen.Show()
			}
			composable(third.route) {
				ThirdScreen.Show()
			}
		}

	}

	@Composable
	private fun Buttons(
		navController: NavHostController
	) {
		Column(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Button(onClick = { navController.navigate(first.routeWithParams) }) {
				Text(text = "First")
			}
			Button(
				onClick = { navController.navigate(second.routeWithParams) }
			) {
				Text(text = "Second")
			}
			Button(onClick = { navController.navigate(third.route) }) {
				Text(text = "Third")
			}
		}
	}


}