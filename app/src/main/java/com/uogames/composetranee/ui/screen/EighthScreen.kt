package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object EighthScreen {


	@Composable
	fun Show(
		modifier: Modifier = Modifier
	) {
		IndexedLazy()
	}

	@Composable
	private fun IndexedLazy() {
		LazyColumn {
			itemsIndexed(
				listOf("This", "is", "Jetpack", "Compose")
			) { i, string ->
				Text(
					text = string,
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.Center,
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 24.dp)
				)
			}
		}
	}

	@Composable
	private fun LazyScroll() {
		LazyColumn {
			items(50000) {
				Text(
					text = it.toString(),
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.Center,
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 24.dp)
				)
			}
		}
	}

	@Composable
	private fun ColumnsScroll() {
		val scroll = rememberScrollState()
		Column(
			modifier = Modifier.verticalScroll(scroll)
		) {
			repeat(50) {
				Text(
					text = it.toString(),
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.Center,
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 24.dp)
				)
			}
		}
	}


}