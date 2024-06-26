package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uogames.composetranee.ui.screen.tenth.TenthScreen
import com.uogames.composetranee.ui.screen.thirteenth.ThirteenthScreen

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
	private val ninth = Destination(route = "ninth")
	private val tenth = Destination(route = "tenth")
	private val eleventh = Destination(route = "eleventh")
	private val twelfth = Destination(route = "twelfth")
	private val thirteenth = Destination(route = "thirteenth")
	private val fourteenth = Destination(route = "fourteenth")
	private val fifteenth = Destination(route = "fifteenth")

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
			composable(eighth.route) { EighthScreen.Show() }
			composable(ninth.route) { NinthScreen.Show() }
			composable(tenth.route) { TenthScreen.Show() }
			composable(eleventh.route) { EleventhScreen.Show() }
			composable(twelfth.route) { TwelfthScreen.Show() }
			composable(thirteenth.route) { ThirteenthScreen.Show() }
			composable(fourteenth.route) { FourteenthScreen.Show() }
			composable(fifteenth.route) { FifteenthScreen.Show() }
		}
	}

	@Composable
	private fun Buttons(
		navController: NavHostController
	) {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp),
			contentAlignment = Alignment.TopCenter,
		) {
			LazyVerticalGrid(columns = GridCells.Adaptive(150.dp)) {
				items(Buttons.entries.size) {
					Buttons.entries[it].Run(navController)
				}
			}
		}
	}

	private enum class Buttons(
		val route: String,
		val text: String
	) {
		FIRST(first.routeWithParams, "First"),
		SECOND(second.routeWithParams, "Second"),
		THIRD(third.routeWithParams, "Third"),
		FOURTH(forth.routeWithParams, "Fourth"),
		FIFTH(fifth.routeWithParams, "Fifth"),
		SIXTH(sixth.routeWithParams, "Sixth"),
		SEVENTH(seventh.routeWithParams, "Seventh"),
		EIGHTH(eighth.routeWithParams, "Eighth"),
		NINTH(ninth.routeWithParams, "Ninth"),
		TENTH(tenth.routeWithParams, "Tenth"),
		ELEVENTH(eleventh.routeWithParams, "Eleventh"),
		TWELFTH(twelfth.routeWithParams, "Twelfth"),
		THIRTEENTH(thirteenth.routeWithParams, "Thirteenth"),
		FOURTEENTH(fourteenth.routeWithParams, "Fourteenth"),
		FIFTEENTH(fifteenth.routeWithParams, "Fifteenth")
		;

		@Composable
		fun Run(navController: NavHostController) {
			Button(
				modifier = Modifier.fillMaxWidth(),
				onClick = { navController.navigate(route) }
			) {
				Text(text = text)
			}
		}

	}


}