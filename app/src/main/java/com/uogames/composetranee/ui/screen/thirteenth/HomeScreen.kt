package com.uogames.composetranee.ui.screen.thirteenth

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.uogames.composetranee.R
import java.util.UUID

object HomeScreen {

	@Composable
	fun Show(
		modifier: Modifier = Modifier.fillMaxSize()
	) {
		val scrollState = rememberScrollState()
		ConstraintLayout {
			val boxID = UUID.randomUUID()
			val barID = UUID.randomUUID()
			val constraints = ConstraintSet {
				val box = createRefFor(boxID)
				val bar = createRefFor(barID)
				constrain(box) {
					top.linkTo(parent.top)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					bottom.linkTo(bar.top)
					height = Dimension.fillToConstraints
				}
				constrain(bar) {
					top.linkTo(box.bottom)
					start.linkTo(parent.start)
					bottom.linkTo(parent.bottom)
					end.linkTo(parent.end)
				}

			}
			ConstraintLayout(
				constraints,
				modifier = modifier
			) {
				BottomMenu(items = items, modifier = Modifier.layoutId(barID))
				Column(
					modifier = Modifier

						.verticalScroll(scrollState)
						.layoutId(boxID)
				) {
					GreetingSection()
					ChipSection(chip = listOf("Sweet sleep", "Insomnia", "Depression"))
					CurrentMeditation()
					FeatureSection(features = features)
				}

			}
		}
	}

	@Composable
	private fun GreetingSection(
		name: String = "Andrei"
	) {
		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.padding(15.dp)
				.fillMaxWidth()
		) {
			Column(
				verticalArrangement = Arrangement.Center
			) {
				Text(
					text = "Good morning, $name",
					style = MaterialTheme.typography.headlineMedium
				)
				Text(
					text = "We wish you have a good day",
					style = MaterialTheme.typography.bodyMedium
				)
			}
			Icon(
				painter = painterResource(id = R.drawable.search_24px),
				contentDescription = "search",
				tint = Color.White,
				modifier = Modifier.size(24.dp)
			)
		}
	}

	@Composable
	private fun ChipSection(
		chip: List<String>
	) {
		var selectedChipIndex by remember { mutableIntStateOf(0) }

		LazyRow(
			userScrollEnabled = false
		) {
			items(chip.size) {
				Box(
					contentAlignment = Alignment.Center,
					modifier = Modifier
						.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
						.clip(RoundedCornerShape(10.dp))
						.background(if (selectedChipIndex == it) MyTheme.ColorStack.BUTTON_BLUE else MyTheme.ColorStack.DARKER_BUTTON_BLUE)
						.clickable {
							selectedChipIndex = it
						}
						.padding(15.dp)
				) {
					Text(text = chip[it], color = MyTheme.ColorStack.TEXT_WHITE)
				}
			}
		}

	}

	@Composable
	private fun CurrentMeditation(
		color: Color = MyTheme.ColorStack.LIGHT_RED
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = Modifier
				.padding(15.dp)
				.clip(RoundedCornerShape(10.dp))
				.background(color)
				.padding(horizontal = 15.dp, vertical = 20.dp)
				.fillMaxWidth()
		) {
			Column {
				Text(
					text = "Daily Thought",
					style = MaterialTheme.typography.headlineMedium
				)
				Text(
					text = "Meditation 3 - 10 min",
					style = MaterialTheme.typography.bodyMedium,
					color = MyTheme.ColorStack.TEXT_WHITE
				)
			}
			Box(
				contentAlignment = Alignment.Center,
				modifier = Modifier
					.size(40.dp)
					.clip(CircleShape)
					.background(MyTheme.ColorStack.BUTTON_BLUE)
					.padding(10.dp)
			) {
				Icon(
					painter = painterResource(id = R.drawable.baseline_play_arrow_24),
					contentDescription = "Play",
					tint = Color.White,
					modifier = Modifier.size(16.dp)
				)
			}
		}
	}

	@Composable
	private fun FeatureSection(
		features: List<Feature>
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {
			Text(
				text = "Features",
				style = MaterialTheme.typography.headlineMedium,
				modifier = Modifier.padding(15.dp)
			)
			VerticalGrid(
				columns = 2,
				modifier = Modifier
					.fillMaxHeight()
					.padding(7.5.dp)
			) {
				features.forEachIndexed { i, item ->
					FeatureItem(feature = item)
				}
			}

//			LazyVerticalGrid(
//				columns = GridCells.Fixed(2),
//				contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
//				modifier = Modifier.fillMaxHeight(),
//
//				) {
//				items(features.size) {
//					FeatureItem(feature = features[it])
//				}
//			}
		}
	}

	@Composable
	private fun FeatureItem(
		feature: Feature,
		modifier: Modifier = Modifier
	) {
		BoxWithConstraints(
			modifier = modifier
				.padding(7.5.dp)
				.aspectRatio(1f)
				.clip(RoundedCornerShape(10.dp))
				.background(feature.darkColor)
		) {
			val width = constraints.maxWidth
			val height = constraints.maxHeight

			val mediumColoredPoint1 = Offset(0f, height * 0.3f)
			val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
			val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
			val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
			val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

			val mediumColoredPath = Path().apply {
				moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
				standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
				standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
				standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
				standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
				lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
				lineTo(-100f, height.toFloat() + 100f)
				close()
			}

			val lightPoint1 = Offset(0f, height * 0.3f)
			val lightPoint2 = Offset(width * 0.1f, height * 0.35f)
			val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
			val lightPoint4 = Offset(width * 0.65f, height.toFloat())
			val lightPoint5 = Offset(width * 1.4f, -height.toFloat())

			val lightColoredPath = Path().apply {
				moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
				standardQuadFromTo(lightPoint1, lightPoint2)
				standardQuadFromTo(lightPoint2, lightPoint3)
				standardQuadFromTo(lightPoint3, lightPoint4)
				standardQuadFromTo(lightPoint4, lightPoint5)
				lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
				lineTo(-100f, height.toFloat() + 100f)
				close()
			}

			Canvas(modifier = Modifier.fillMaxSize()) {
				drawPath(path = mediumColoredPath, color = feature.mediumColor)
				drawPath(path = lightColoredPath, color = feature.lightColor)
			}
			Box(
				modifier = Modifier
					.fillMaxSize()
					.padding(15.dp)
			) {
				Text(
					text = feature.title,
					style = MaterialTheme.typography.headlineMedium,
					lineHeight = 26.sp,
					modifier = Modifier.align(Alignment.TopStart)
				)
				Icon(
					painter = painterResource(id = feature.iconID),
					contentDescription = feature.title,
					tint = Color.White,
					modifier = Modifier.align(Alignment.BottomStart)
				)
				Text(text = "Start",
					color = MyTheme.ColorStack.TEXT_WHITE,
					fontSize = 14.sp,
					fontWeight = FontWeight.Bold,
					modifier = Modifier
						.clickable {
							// Handle the click
						}
						.align(Alignment.BottomEnd)
						.clip(RoundedCornerShape(10.dp))
						.background(MyTheme.ColorStack.BUTTON_BLUE)
						.padding(vertical = 6.dp, horizontal = 15.dp)
				)
			}
		}
	}

	@Composable
	private fun BottomMenu(
		items: List<BottomMenuContent>,
		modifier: Modifier = Modifier,
		activeHightliteColor: Color = MyTheme.ColorStack.BUTTON_BLUE,
		activeTextColor: Color = Color.White,
		inactiveTextColor: Color = MyTheme.ColorStack.AQUA_BLUE,
		initialSelectedItemIndex: Int = 0
	) {
		var selectedItemIndex by remember { mutableIntStateOf(initialSelectedItemIndex) }
		Row(
			horizontalArrangement = Arrangement.SpaceAround,
			verticalAlignment = Alignment.CenterVertically,
			modifier = modifier
				.fillMaxWidth()
				.background(MyTheme.ColorStack.DEEP_BLUE)
				.padding(15.dp)
		) {
			items.forEachIndexed { i, item ->
				BottomMenuItem(
					item = item,
					isSelected = i == selectedItemIndex,
					activeHightliteColor = activeHightliteColor,
					activeTextColor = activeTextColor,
					inactiveTextColor = inactiveTextColor
				) {
					selectedItemIndex = i
				}
			}
		}
	}

	@Composable
	private fun BottomMenuItem(
		item: BottomMenuContent,
		isSelected: Boolean = false,
		activeHightliteColor: Color = MyTheme.ColorStack.BUTTON_BLUE,
		activeTextColor: Color = Color.White,
		inactiveTextColor: Color = MyTheme.ColorStack.AQUA_BLUE,
		onItemClick: () -> Unit
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Box(
				contentAlignment = Alignment.Center,
				modifier = Modifier
					.clip(RoundedCornerShape(10.dp))
					.background(if (isSelected) activeHightliteColor else Color.Transparent)
					.clickable {
						onItemClick()
					}
					.padding(10.dp)
			) {
				Icon(
					painter = painterResource(id = item.iconID),
					contentDescription = item.title,
					tint = if (isSelected) activeTextColor else inactiveTextColor,
					modifier = Modifier.size(20.dp)
				)
			}
			Text(
				text = item.title,
				color = if (isSelected) activeTextColor else inactiveTextColor
			)
		}
	}


}