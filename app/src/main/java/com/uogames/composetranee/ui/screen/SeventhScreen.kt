package com.uogames.composetranee.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

object SeventhScreen {


	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	@Composable
	fun Show(
		modifier: Modifier = Modifier
	) {
		val scaffoldState = remember { SnackbarHostState() }
		var textField by remember { mutableStateOf("") }
		val scope = rememberCoroutineScope()
		val imm = LocalContext.current.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		val token = LocalView.current.windowToken
		Box(
			modifier = modifier
		) {
			Scaffold(
				modifier = Modifier.fillMaxSize(),
				snackbarHost = { SnackbarHost(hostState = scaffoldState) },
				content = {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center,
						modifier = Modifier
							.fillMaxSize()
							.padding(horizontal = 30.dp)
					) {
						OutlinedTextField(
							value = textField,
							onValueChange = { textField = it },
							label = { Text(text = "Enter your name") },
							singleLine = true,
							modifier = Modifier.fillMaxWidth()
						)
						Spacer(modifier = Modifier.height(16.dp))
						Button(onClick = {
							scope.launch {
								imm.hideSoftInputFromWindow(token,0)
								scaffoldState.showSnackbar("Hello $textField")
							}
						}) {
							Text(text = "Pls greet me")
						}
					}
				}
			)
		}

	}


}