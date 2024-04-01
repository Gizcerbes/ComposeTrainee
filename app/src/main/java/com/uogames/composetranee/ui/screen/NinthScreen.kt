package com.uogames.composetranee.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import java.util.UUID

object NinthScreen {


	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		Box(modifier = modifier) {

			Column(modifier = Modifier.fillMaxSize()) {
				Spacer(modifier = Modifier.height(16.dp))
				First()
				Spacer(modifier = Modifier.height(16.dp))
				Second()
				Spacer(modifier = Modifier.height(16.dp))
				Third()
				Spacer(modifier = Modifier.height(16.dp))
				Forth()
			}
		}


	}

	@Composable
	private fun First() {
		val greenBoxID = UUID.randomUUID()
		val redBoxID = UUID.randomUUID()

		val constraints = ConstraintSet {
			val greenBox = createRefFor(greenBoxID)
			val redBox = createRefFor(redBoxID)

			constrain(greenBox) {
				top.linkTo(parent.top)
				start.linkTo(parent.start)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			constrain(redBox) {
				top.linkTo(parent.top)
				start.linkTo(greenBox.end)
				end.linkTo(parent.end)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			createHorizontalChain(greenBox, redBox)
		}

		ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
			Box(
				modifier = Modifier
					.background(Color.Green)
					.layoutId(greenBoxID)
			)
			Box(
				modifier = Modifier
					.background(Color.Red)
					.layoutId(redBoxID)
			)
		}
	}

	@Composable
	private fun Second() {
		val greenBoxID = UUID.randomUUID()
		val redBoxID = UUID.randomUUID()

		val constraints = ConstraintSet {
			val greenBox = createRefFor(greenBoxID)
			val redBox = createRefFor(redBoxID)

			constrain(greenBox) {
				top.linkTo(parent.top)
				start.linkTo(parent.start)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			constrain(redBox) {
				top.linkTo(parent.top)
				start.linkTo(greenBox.end)
				end.linkTo(parent.end)
				width = Dimension.fillToConstraints
				height = Dimension.value(100.dp)
			}
		}

		ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
			Box(
				modifier = Modifier
					.background(Color.Green)
					.layoutId(greenBoxID)
			)
			Box(
				modifier = Modifier
					.background(Color.Red)
					.layoutId(redBoxID)
			)
		}
	}

	@Composable
	private fun Third() {
		val greenBoxID = UUID.randomUUID()
		val redBoxID = UUID.randomUUID()

		val constraints = ConstraintSet {
			val greenBox = createRefFor(greenBoxID)
			val redBox = createRefFor(redBoxID)

			constrain(greenBox) {
				top.linkTo(parent.top)
				start.linkTo(parent.start)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			constrain(redBox) {
				top.linkTo(parent.top)
				start.linkTo(greenBox.end)
				end.linkTo(parent.end)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
		}

		ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
			Box(
				modifier = Modifier
					.background(Color.Green)
					.layoutId(greenBoxID)
			)
			Box(
				modifier = Modifier
					.background(Color.Red)
					.layoutId(redBoxID)
			)
		}
	}

	@Composable
	private fun Forth(){
		val greenBoxID = UUID.randomUUID()
		val redBoxID = UUID.randomUUID()
		val guideLineID = UUID.randomUUID()

		val constraints = ConstraintSet {
			val greenBox = createRefFor(greenBoxID)
			val redBox = createRefFor(redBoxID)
			val guideLine = createGuidelineFromTop(0.1f)

			constrain(greenBox) {
				top.linkTo(guideLine)
				start.linkTo(parent.start)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			constrain(redBox) {
				top.linkTo(parent.top)
				start.linkTo(greenBox.end)
				end.linkTo(parent.end)
				width = Dimension.value(100.dp)
				height = Dimension.value(100.dp)
			}
			createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
		}

		ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
			Box(
				modifier = Modifier
					.background(Color.Green)
					.layoutId(greenBoxID)
			)
			Box(
				modifier = Modifier
					.background(Color.Red)
					.layoutId(redBoxID)
			)
		}
	}


}