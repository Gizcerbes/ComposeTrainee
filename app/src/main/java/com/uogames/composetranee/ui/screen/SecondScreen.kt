package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object SecondScreen {


	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		Box(modifier = modifier.fillMaxSize()) {
			Column {
				First()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Second()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Third()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Fourth()
			}
		}
	}


	@Composable
	private fun First() {
		Column {
			Text(text = "Hello")
			Text(text = "World")
		}
	}

	@Composable
	private fun Second() {
		Row(
			modifier = Modifier.background(Color.Yellow)
		) {
			Text(text = "Hello")
			Text(text = "World")
		}
	}

	@Composable
	private fun Third() {
		Column(
			modifier = Modifier
				.background(Color.Green)
				.fillMaxWidth()
			,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(text = "Hello")
			Text(text = "World")
		}
	}

	@Composable
	private fun Fourth(){
		Row {
			Column(
				modifier = Modifier
					.fillMaxWidth(0.25f)
					.height(100.dp)
					.background(Color.LightGray),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Center")
			}
			Column(
				modifier = Modifier
					.fillMaxWidth(0.33f)
					.height(100.dp)
					.background(Color.LightGray),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.SpaceBetween
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Between")
			}
			Column(
				modifier = Modifier
					.fillMaxWidth(0.5f)
					.height(100.dp)
					.background(Color.LightGray),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.SpaceEvenly
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Evenly")
			}
			Column(
				modifier = Modifier
					.fillMaxWidth(1f)
					.height(100.dp)
					.background(Color.LightGray),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.SpaceAround
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Around")
			}
		}

	}


}