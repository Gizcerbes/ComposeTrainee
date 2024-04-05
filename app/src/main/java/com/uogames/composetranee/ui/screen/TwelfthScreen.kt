package com.uogames.composetranee.ui.screen

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uogames.composetranee.R
import java.nio.file.WatchEvent
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.roundToInt

object TwelfthScreen {


	@Composable
	fun Show(
		modifier: Modifier = Modifier
	) {
		Box(
			modifier = modifier
				.fillMaxSize()
				.background(Color.Gray),
			contentAlignment = Alignment.Center,
		) {
			Row(
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.border(1.dp, Color.Green, RoundedCornerShape(10.dp))
					.padding(30.dp)
			) {
				var voluem by remember {
					mutableFloatStateOf(0f)
				}
				val barCount = 20
				MusicKnob(
					modifier = Modifier.size(100.dp)
				) {
					voluem = it
				}
				Spacer(modifier = Modifier.width(20.dp))
				VolumeBar(
					modifier = Modifier
						.fillMaxWidth()
						.height(30.dp),
					activeBars = (barCount * voluem).roundToInt(),
					barCount = barCount
				)
			}
		}
	}


	@OptIn(ExperimentalComposeUiApi::class)
	@Composable
	private fun MusicKnob(
		modifier: Modifier = Modifier,
		limitAngle: Float = 25f,
		onValueChange: (Float) -> Unit
	) {
		var rotation by remember { mutableFloatStateOf(limitAngle) }
		var touchX by remember { mutableFloatStateOf(0f) }
		var touchY by remember { mutableFloatStateOf(0f) }
		var centerX by remember { mutableFloatStateOf(0f) }
		var centerY by remember { mutableFloatStateOf(0f) }

		Image(
			painter = painterResource(id = R.drawable.knob),
			contentDescription = "Music Knob",
			modifier = modifier
				.fillMaxSize()
				.onGloballyPositioned {
					val windowBound = it.boundsInWindow()
					centerX = windowBound.size.width / 2f
					centerY = windowBound.size.height / 2f
				}
				.pointerInteropFilter {
					touchX = it.x
					touchY = it.y
					val angle = -atan2(centerX - touchX, centerY - touchY) * (180f / PI).toFloat()
					when (it.action) {
						MotionEvent.ACTION_DOWN,
						MotionEvent.ACTION_MOVE -> {
							if (angle !in -limitAngle..limitAngle) {
								val fixAngle = if (angle in -180f..-limitAngle) 360f + angle else angle
								rotation = fixAngle
								val percent = (fixAngle - limitAngle) / (360f - 2 * limitAngle)
								onValueChange(percent)
							}
						}
					}
					true
				}
				.rotate(rotation)
		)
	}

	@Composable
	fun VolumeBar(
		modifier: Modifier = Modifier,
		activeBars: Int = 0,
		barCount: Int = 10
	) {
		BoxWithConstraints(
			contentAlignment = Alignment.Center,
			modifier = modifier
		) {
			val barWith = remember {
				constraints.maxWidth / (2f * barCount)
			}
			Canvas(modifier = modifier) {
				repeat(barCount) {
					drawRoundRect(
						color = if (it in 0..activeBars) Color.Green else Color.DarkGray,
						topLeft = Offset(it * barWith * 2f + barWith / 2f, 0f),
						size = Size(barWith, constraints.maxHeight.toFloat()),
						cornerRadius = CornerRadius(0f)
					)
				}
			}
		}
	}


}