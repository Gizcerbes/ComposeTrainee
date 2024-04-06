package com.uogames.composetranee.ui.screen.thirteenth

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uogames.composetranee.R
import com.uogames.composetranee.ui.theme.Pink40
import com.uogames.composetranee.ui.theme.Purple40
import com.uogames.composetranee.ui.theme.PurpleGrey40


object MyTheme {

	object ColorStack {

		val TEXT_WHITE = Color(0xFFEEEEEE)
		val DEEP_BLUE = Color(0xFF06164C)
		val BUTTON_BLUE = Color(0xFF505CF3)
		val DARKER_BUTTON_BLUE = Color(0xFF566894)
		val LIGHT_RED = Color(0xFFFC879A)
		val AQUA_BLUE = Color(0xFF9AA5C4)
		val ORANGE_YELLOW_1 = Color(0xFFF0BD28)
		val ORANGE_YELLOW_2 = Color(0xFFF1C746)
		val ORANGE_YELLOW_3 = Color(0xFFF4CF65)
		val BEIGE_1 = Color(0xFFFDBDA1)
		val BEIGE_2 = Color(0xFFFCAF90)
		val BEIGE_3 = Color(0xFFF9A27B)
		val LIGHT_GREEN_1 = Color(0xFF54E1B6)
		val LIGHT_GREEN_2 = Color(0xFF36DDAB)
		val LIGHT_GREEN_3 = Color(0xFF11D79B)
		val BLUE_VIOLET_1 = Color(0xFFAEB4FD)
		val BLUE_VIOLET_2 = Color(0xFF9FA5FE)
		val BLUE_VIOLET_3 = Color(0xFF8F98FD)
	}


	private val fontFamily = FontFamily(
		listOf(
			Font(R.font.gothica_regular, FontWeight.Normal),
			Font(R.font.gothica_medium, FontWeight.Medium),
			Font(R.font.gothica_semi_bold, FontWeight.SemiBold),
			Font(R.font.gothica_bold, FontWeight.Bold),
			Font(R.font.gothica_black, FontWeight.Black)
		)
	)

	private val LightColorScheme = lightColorScheme(
		primary = Purple40,
		secondary = PurpleGrey40,
		tertiary = Pink40
	)

	private val typography = Typography(
		bodyMedium = TextStyle(
			color = ColorStack.AQUA_BLUE,
			fontFamily = fontFamily,
			fontWeight = FontWeight.Normal,
			fontSize = 14.sp
		),
		headlineMedium = TextStyle(
			color = ColorStack.TEXT_WHITE,
			fontFamily = fontFamily,
			fontWeight = FontWeight.Bold,
			fontSize = 22.sp
		)
	)


	@Composable
	fun Theme(
		content: @Composable () -> Unit
	) {

		MaterialTheme(
			colorScheme = LightColorScheme,
			typography = typography,
			content = content
		)

	}


}

