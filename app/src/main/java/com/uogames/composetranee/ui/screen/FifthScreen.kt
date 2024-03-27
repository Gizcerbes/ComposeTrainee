package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.uogames.composetranee.ui.theme.Font

object FifthScreen {

	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		Box(
			modifier = modifier
				.fillMaxSize()
				.background(Color.Black)
		) {
			Column {
				First()
				HorizontalDivider()
				Second()
				HorizontalDivider()
				Third()
				HorizontalDivider()
				Forth()
				HorizontalDivider()
			}
		}
	}


	@Composable
	private fun First() {
		Text(
			text = "Jetpack Compose",
			color = Color.White,
			fontSize = 30.sp
		)
	}

	@Composable
	private fun Second() {
		//https://fonts.google.com/
		Text(
			text = "Jetpack Compose",
			color = Color.White,
			fontSize = 30.sp,
			fontFamily = Font.LEXEND
		)
	}

	@Composable
	private fun Third() {
		//https://fonts.google.com/
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = "Jetpack Compose",
			color = Color.White,
			fontSize = 30.sp,
			fontFamily = Font.LEXEND,
			fontWeight = FontWeight.Bold,
			fontStyle = FontStyle.Italic,
			textAlign = TextAlign.Center,
			textDecoration = TextDecoration.Underline
		)
	}

	@Composable
	private fun Forth() {
		//https://fonts.google.com/
		Text(
			modifier = Modifier.fillMaxWidth(),
			text = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						color = Color.Green,
						fontSize = 50.sp
					)
				){
					append("J")
				}
				append("etpack")
				withStyle(
					style = SpanStyle(
						color = Color.Green,
						fontSize = 50.sp
					)
				){
					append("C")
				}
				append("ompose")
			},
			color = Color.White,
			fontSize = 30.sp,
			fontFamily = Font.LEXEND,
			fontWeight = FontWeight.Bold,
			fontStyle = FontStyle.Italic,
			textAlign = TextAlign.Center,
			textDecoration = TextDecoration.Underline,

		)
	}


}