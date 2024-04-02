package com.uogames.composetranee.ui.screen.tenth

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uogames.composetranee.ui.screen.FifthScreen

object TenthScreen {

	private enum class Destination(val route: String, val box: @Composable () -> Unit) {
		D1("1", { First() }),
		D2("2", { Second() }),
		D3("3", { Third() }),
		D4("4", { Forth() }),
		D5("5", { Fifth() })
	}

	@Composable
	fun Show() {
		val navController = rememberNavController()
		NavHost(navController = navController, startDestination = "start") {
			composable("start") { BTNS(navController = navController) }
			Destination.entries.forEach { destination -> composable(destination.route) { destination.box() }  }
		}
	}

	@Composable
	private fun BTN(navController: NavHostController, route: String, text: String) {
		Button(
			modifier = Modifier.fillMaxWidth(),
			onClick = { navController.navigate(route) }
		) {
			Text(text = text)
		}
	}

	@Composable
	private fun BTNS(
		navController: NavHostController
	) {
		Box(modifier = Modifier.fillMaxSize()) {
			Column {
				Destination.entries.forEach { BTN(navController = navController, route = it.route, text = it.route) }
			}
		}

	}

	@Composable
	private fun First() {
		Box(modifier = Modifier.fillMaxSize()) {
			var sizeState by remember { mutableStateOf(200.dp) }
			val size by animateDpAsState(targetValue = sizeState, label = "")
			Box(
				modifier = Modifier
					.size(size)
					.background(Color.Red),
				contentAlignment = Alignment.Center
			) {
				Button(onClick = {
					sizeState += 50.dp
				}) {
					Text(text = "Increase size")
				}
			}
		}
	}

	@Composable
	private fun Second() {
		Box(modifier = Modifier.fillMaxSize()) {
			var sizeState by remember { mutableStateOf(200.dp) }
			val size by animateDpAsState(
				targetValue = sizeState,
				tween(
					durationMillis = 3000,
					delayMillis = 300,
					easing = LinearOutSlowInEasing
				),
				label = ""
			)
			Box(
				modifier = Modifier
					.size(size)
					.background(Color.Red),
				contentAlignment = Alignment.Center
			) {
				Button(onClick = {
					sizeState += 50.dp
				}) {
					Text(text = "Increase size")
				}
			}
		}
	}

	@Composable
	private fun Third() {
		Box(modifier = Modifier.fillMaxSize()) {
			var sizeState by remember { mutableStateOf(200.dp) }
			val size by animateDpAsState(
				targetValue = sizeState,
				spring(
					Spring.DampingRatioHighBouncy,

					),
				label = ""
			)
			Box(
				modifier = Modifier
					.size(size)
					.background(Color.Red),
				contentAlignment = Alignment.Center
			) {
				Button(onClick = {
					sizeState += 50.dp
				}) {
					Text(text = "Increase size")
				}
			}
		}
	}

	@Composable
	private fun Forth() {
		Box(modifier = Modifier.fillMaxSize()) {
			var sizeState by remember { mutableStateOf(200.dp) }
			val size by animateDpAsState(
				targetValue = sizeState,
				keyframes {
					durationMillis = 1000
					//sizeState at 0
					sizeState * 1.5f at 300
					sizeState * 0.75f at 600
				},
				label = ""
			)
			Box(
				modifier = Modifier
					.size(size)
					.background(Color.Red),
				contentAlignment = Alignment.Center
			) {
				Button(onClick = {
					sizeState += 50.dp
				}) {
					Text(text = "Increase size")
				}
			}
		}
	}

	@Composable
	private fun Fifth() {
		Box(modifier = Modifier.fillMaxSize()) {
			var sizeState by remember { mutableStateOf(200.dp) }
			val size by animateDpAsState(
				targetValue = sizeState,
				tween(
					durationMillis = 1000
				),
				label = ""
			)
			val infiniteTransition = rememberInfiniteTransition(label = "")
			val color by infiniteTransition.animateColor(
				initialValue = Color.Red,
				targetValue = Color.Green,
				animationSpec = infiniteRepeatable(
					tween(durationMillis = 2000),
					repeatMode = RepeatMode.Reverse
				), label = ""
			)
			Box(
				modifier = Modifier
					.size(size)
					.background(color),
				contentAlignment = Alignment.Center
			) {
				Button(onClick = {
					sizeState += 50.dp
				}) {
					Text(text = "Increase size")
				}
			}
		}
	}


}