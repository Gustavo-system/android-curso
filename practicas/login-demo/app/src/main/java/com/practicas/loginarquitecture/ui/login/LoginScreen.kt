package com.practicas.loginarquitecture.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicas.loginarquitecture.R
import com.practicas.loginarquitecture.presentation.login.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Login(modifier = Modifier.align(Alignment.Center), viewModel)
        Spacer(modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val btnLogin: Boolean by viewModel.btnLoginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

    val coroutineScope = rememberCoroutineScope()

    if(isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    else {
        Column(modifier = modifier) {
            HeaderImage(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            EmailText(email, { viewModel.onLoginChanged(it, password) })
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordText(password, { viewModel.onLoginChanged(email, it) })
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(8.dp))
            LoginButton(btnLogin, {
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            })
        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_logo_login),
        contentDescription = null
    )
}

@Composable
fun EmailText(email: String, onTextFieldChanged:(String) -> Unit) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun PasswordText(
    password:String,
    onTextFieldChanged:(String) -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        modifier = modifier.clickable {  },
        text = "¿Olvidaste la contraseña?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
    )
}


@Composable
fun LoginButton(
    loginEnabled: Boolean,
    onLoginSelected:() -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFDC2626),
            contentColor = Color.White,
            disabledContainerColor =  Color(0xFFE37E7E)
        ),
        enabled = loginEnabled,
        onClick = {
            onLoginSelected()
        }
    ) {
        Text(text = "Iniciar Sesion")
    }
}