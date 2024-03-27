package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object ThirdScreen {

	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		Box(
			modifier = modifier
				.fillMaxHeight(0.5f)
				.width(300.dp)
		) {
			Box(
				modifier = Modifier
					.fillMaxHeight(0.5f)
					.width(300.dp)
					.background(Color.Green)
					.border(5.dp, Color.Magenta)
					.padding(5.dp)
					.border(5.dp, Color.Blue)
					.padding(5.dp)
					.border(10.dp, Color.Red)
					.padding(10.dp)
					.clickable {

					}
			) {
				Column {
					Text(text = "Hello", modifier = Modifier
						.border(5.dp, Color.Yellow)
						.padding(5.dp)
						.offset(30.dp, 20.dp)
						.border(10.dp, Color.Black)
						.padding(10.dp)
						.clickable {

						}
					)
					Spacer(modifier = Modifier.height(50.dp))
					Text(text = "World")
				}
			}
		}
	}


}