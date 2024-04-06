package com.uogames.composetranee.ui.screen.thirteenth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object ThirteenthScreen {

	@Composable
	fun Show(
		modifier: Modifier = Modifier
	) {
		MyTheme.Theme {
			HomeScreen.Show()
		}
	}


}