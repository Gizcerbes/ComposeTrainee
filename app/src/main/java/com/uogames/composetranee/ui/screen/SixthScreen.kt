package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object SixthScreen {


	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		var color by remember { mutableStateOf(Color.Yellow) }
		var second by remember { mutableStateOf(Color.Yellow) }
		val updateColor = { it: Color ->
			second = color
			color = it
		}
		Column {
			ColorBox(
				modifier = Modifier
					.weight(1f)
					.fillMaxSize(),
				color,
				updateColor = updateColor
			)
			Box(
				modifier = Modifier
					.background(second)
					.weight(1f)
					.fillMaxSize()
					.clickable {
						updateColor(
							Color(
								Random.nextFloat(),
								Random.nextFloat(),
								Random.nextFloat(),
								1f
							)
						)
					}
			) {

			}
		}
	}

	@Composable
	private fun ColorBox(
		modifier: Modifier = Modifier,
		color: Color,
		updateColor: (Color) -> Unit
	) {
		Box(
			modifier = modifier
				.background(color)
				.clickable {
					updateColor(
						Color(
							Random.nextFloat(),
							Random.nextFloat(),
							Random.nextFloat(),
							1f
						)
					)
				}
		) {

		}
	}


}