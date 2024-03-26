package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview()
//@Composable
//fun FirstScreenPreview(){
//	FirstScreen.Show()
//}

object FirstScreen {

	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		Box(
			modifier = modifier,
			contentAlignment = Alignment.Center
		) {
			val scrollState = rememberScrollState()
			Column(modifier = Modifier
				.fillMaxSize()
				.verticalScroll(scrollState)) {
				Row {
					Text(text = "Hello")
					Spacer(modifier = Modifier.size(3.dp))
					Text(text = "Screen")
				}
				repeat(40) { Text(text = it.toString()) }
			}
		}

	}


}