package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uogames.composetranee.R

object ForthScreen {


	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		val painter = painterResource(id = R.drawable.nero)
		val description = "It is Nero"
		val title = description
		Box(
			modifier = modifier
				.padding(16.dp)
		) {
			ImageCard(
				painter = painter,
				contentDescription = description,
				title = title,
				modifier = Modifier.fillMaxWidth(0.5f),
				onClick = {}
			)
		}
	}

	@Composable
	private fun ImageCard(
		painter: Painter,
		contentDescription: String,
		title: String,
		modifier: Modifier = Modifier,
		onClick: (() -> Unit)? = null
	) {
		ElevatedCard(
			modifier = modifier,
			shape = RoundedCornerShape(15.dp),
			elevation = CardDefaults.cardElevation(5.dp),
			enabled = onClick != null,
			onClick = onClick ?: {},
		) {
			Box(
				modifier = Modifier
					.height(200.dp),
				contentAlignment = Alignment.BottomStart
			) {
				Image(
					painter = painter,
					contentDescription = contentDescription,
					contentScale = ContentScale.Crop
				)
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.fillMaxHeight(0.5f)
//						.background(
//							brush = Brush.verticalGradient(
//								colors = listOf(
//									Color.Transparent,
//									Black50
//								)
//							)
//						)
						.padding(12.dp)
					,
					contentAlignment = Alignment.BottomStart
				) {
					Text(
						text = title,
						style = TextStyle(
							color = Color.White,
							fontSize = 16.sp
						)
					)
				}
			}
		}
	}


}