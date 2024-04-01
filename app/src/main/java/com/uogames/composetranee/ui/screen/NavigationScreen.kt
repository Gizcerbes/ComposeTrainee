package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
	private val forth = Destination(route = "forth")
	private val fifth = Destination(route = "fifth")
	private val sixth = Destination(route = "sixth")
	private val seventh = Destination(route = "seventh")
	private val eighth = Destination(route = "eighth")

	@Composable
	fun Show() {
		val navController = rememberNavController()
		NavHost(navController = navController, startDestination = navigator.route) {
			composable(navigator.route) { Buttons(navController = navController) }
			composable(first.route) { FirstScreen.Show() }
			composable(second.route) { SecondScreen.Show() }
			composable(third.route) { ThirdScreen.Show() }
			composable(forth.route) { ForthScreen.Show() }
			composable(fifth.route) { FifthScreen.Show() }
			composable(sixth.route) { SixthScreen.Show() }
			composable(seventh.route) { SeventhScreen.Show() }
		}
	}

	@Composable
	private fun Buttons(
		navController: NavHostController
	) {
		Box(
			modifier = Modifier.fillMaxSize(),
			contentAlignment = Alignment.TopCenter,
		) {
			Column(modifier = Modifier.fillMaxWidth(0.4f)) {
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(first.routeWithParams) }
				) {
					Text(text = "First")
				}
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(second.routeWithParams) }
				) {
					Text(text = "Second")
				}
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(third.route) }
				) {
					Text(text = "Third")
				}
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(forth.route) }
				) {
					Text(text = "Fourth")
				}
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(fifth.route) }
				) {
					Text(text = "Fifth")
				}
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(sixth.route) }
				) {
					Text(text = "Sixth")
				}
				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = { navController.navigate(seventh.route) }
				) {
					Text(text = "Seventh")
				}
			}
		}
	}


}