package com.example.compacktv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compacktv.R
import com.example.compacktv.ui.theme.DarkRed
import com.example.compacktv.ui.theme.LightRed

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AppIcon()
        AppNameTitle()
        WelcomeTitle()
        Email()
        Password()
        LoginButton(navController)
    }
}

@Composable
fun AppIcon() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Card(
            modifier = Modifier.size(130.dp),
            shape = CircleShape,
            elevation = 2.dp,
        ) {
            Image(
                painter = painterResource(R.drawable.b),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun AppNameTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.text_app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun WelcomeTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Text(
            text = stringResource(R.string.text_welcome),
            style = MaterialTheme.typography.body1,
            color = LightRed
        )
    }
}

@Composable
fun Email() {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        value = emailState.value,
        onValueChange = { emailState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.email_hint),
                color = Color.Gray
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun Password() {
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val showPassword = remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.password_hint),
                color = Color.Gray
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(R.string.hide_password)
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(R.string.show_password)
                    )
                }
            }
        }
    )
}

@Composable
fun LoginButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("movieList") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 5.dp, end = 5.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = DarkRed,
            contentColor = Color.White
        )
    ) {
        Text(
            text = stringResource(R.string.text_button_login)
        )
    }
}