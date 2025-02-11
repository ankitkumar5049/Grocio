package com.example.grocio.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.grocio.navigation.Screen
import com.example.grocio.ui.theme.GrocioTheme

@Composable
fun LoginScreen(navController: NavController?) {

    var name by remember { mutableStateOf("") }
    var loginText by remember { mutableStateOf("Login Screen") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {


        Text(modifier = Modifier
            .padding(5.dp),
            fontStyle = FontStyle.Normal,
            style = TextStyle.Default,
            maxLines = 1,
            fontSize = 30.sp,
            text = loginText)

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            value = name,
            onValueChange = { name = it },
            singleLine = true,
            label = { Text("Name") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            value = password,
            singleLine = true,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            ,onClick = { checkUser(navController, name.trim(), password.trim(), context) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray))
        {
            Text(text = "Login",
                color = Color.Black)
        }


        Text(modifier = Modifier
            .align(Alignment.End)
            .padding(end = 15.dp),
            text = "SignUp here!",
            color = Color.Blue)

    }
}

private fun checkUser(navController: NavController?, name: String, pass: String, context: Context){
    if(name == "Ankit" && pass == "1234"){
        navController?.navigate(route = Screen.Main.route)
    }
    else{
        Toast.makeText(context, "invalid Credentials", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    GrocioTheme {
        LoginScreen(navController = null)
    }
}
