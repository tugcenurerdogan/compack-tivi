package com.example.compacktv.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compacktv.R
import com.example.compacktv.ui.theme.Green

@Composable
fun RegisterScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        InstructionText()
        RegName()
        RegSurname()
        RegEmail()
        CreatePassword()
        ConfirmPassword()
        RegButton(navController)
    }
}

@Composable
fun InstructionText() {
    Text(
        text = stringResource(R.string.text_instruction),
        style = MaterialTheme.typography.body1,
        color = Green,
        modifier = Modifier.padding(10.dp)
    )

}

@Composable
fun RegName() {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        value = emailState.value,
        onValueChange = { emailState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.name_hint),
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
fun RegSurname() {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
        value = emailState.value,
        onValueChange = { emailState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.surname_hint),
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
fun RegEmail() {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
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
fun CreatePassword() {
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val showPassword = remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.create_password_hint),
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
fun ConfirmPassword() {
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val showPassword = remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.confirm_password_hint),
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
fun RegButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("login") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 5.dp, end = 5.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Green,
            contentColor = Color.White
        )
    ) {
        Text(
            text = stringResource(R.string.text_button_register)
        )
    }
}