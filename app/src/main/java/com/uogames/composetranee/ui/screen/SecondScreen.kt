package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
		Box(modifier = modifier) {
			Column {
				First()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Second()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Third()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Fourth()
				HorizontalDivider(modifier = Modifier.fillMaxWidth())
				Fifth()
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
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(text = "Hello")
			Text(text = "World")
		}
	}

	@Composable
	private fun Fourth() {
		Row(modifier = Modifier
			.background(Color.Gray)
			.height(200.dp)
		) {
			Column(
				modifier = Modifier
					.fillMaxHeight()
					.fillMaxWidth(0.25f),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Center")
			}
			Column(
				modifier = Modifier
					.fillMaxHeight()
					.fillMaxWidth(0.33f),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.SpaceBetween
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Between")
			}
			Column(
				modifier = Modifier
					.fillMaxHeight()
					.fillMaxWidth(0.5f),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.SpaceEvenly
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Evenly")
			}
			Column(
				modifier = Modifier
					.fillMaxHeight()
					.fillMaxWidth(1f),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.SpaceAround
			) {
				Text(text = "Hello")
				Text(text = "World")
				Text(text = "Around")
			}
		}
	}

	@Composable
	private fun Fifth() {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Cyan)
		) {
			Row(modifier = Modifier.fillMaxWidth()) {
				repeat(3) { Text(text = it.toString()) }
			}
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically
			) {
				repeat(3) { Text(text = it.toString()) }
			}
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.Bottom
			) {
				repeat(3) { Text(text = it.toString()) }
			}
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceEvenly,
				verticalAlignment = Alignment.Top
			) {
				repeat(3) { Text(text = it.toString()) }
			}
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceAround,
				verticalAlignment = Alignment.CenterVertically
			) {
				repeat(3) { Text(text = it.toString()) }
			}
		}
	}


}