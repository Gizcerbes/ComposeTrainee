package com.uogames.composetranee.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object FifteenthScreen {

	@Composable
	fun Show() {
		DropDown(
			text = "Hello world",
			modifier = Modifier.padding(15.dp)
		) {
			Text(
				text = "This is now revealed",
				modifier = Modifier
					.fillMaxWidth()
					.height(100.dp)
					.background(Color.Green)
			)
		}
	}

	@Composable
	private fun DropDown(
		text: String,
		modifier: Modifier = Modifier,
		initiallyOpened: Boolean = false,
		content: @Composable () -> Unit
	) {
		var isOpen by remember { mutableStateOf(initiallyOpened) }
		val alpha = animateFloatAsState(
			targetValue = if (isOpen) 1f else 0f,
			label = "",
			animationSpec = tween(durationMillis = 300)
		)
		val rotateX = animateFloatAsState(
			targetValue = if (isOpen) 0f else -90f,
			label = "",
			animationSpec = tween(durationMillis = 300)
		)
		Column(modifier = modifier) {
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.fillMaxWidth()
			) {
				Text(
					text = text,
					color = Color.White,
					fontSize = 16.sp,
				)
				Spacer(modifier = Modifier)
				Icon(
					imageVector = Icons.Default.ArrowDropDown,
					contentDescription = "Open Or Close",
					tint = Color.White,
					modifier = Modifier
						.clip(RoundedCornerShape(10.dp))
						.clickable {
							isOpen = !isOpen
						}
						.scale(1f, if (isOpen) -1f else 1f)
				)
			}
			Spacer(modifier = Modifier.height(10.dp))
			Box(
				contentAlignment = Alignment.Center,
				modifier = Modifier
					.fillMaxWidth()
					.graphicsLayer {
						transformOrigin = TransformOrigin(0.5f, 0f)
						rotationX = rotateX.value
					}
					.alpha(alpha.value)
			) {
				content()
			}
		}
	}

}