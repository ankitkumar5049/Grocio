package com.example.grocio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grocio.ProfileTextView
import com.example.grocio.R
import com.example.grocio.ui.theme.GrocioTheme

@Composable
fun ProfileScreen(){
    var isEditMode by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf(TextFieldValue("Ankit Kumar")) }
    var email by remember { mutableStateOf(TextFieldValue("ankitkumar5049@gmail.com")) }
    var phone by remember { mutableStateOf(TextFieldValue("7903888878")) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Image(
            painter = painterResource(R.drawable.dummy),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp))

        if (!isEditMode) {
            // View Mode: Show ProfileTextView
            ProfileTextView(label = "Name: ", text = name.text)
            Spacer(modifier = Modifier.height(15.dp))
            ProfileTextView(label = "Email: ", text = email.text)
            Spacer(modifier = Modifier.height(15.dp))
            ProfileTextView(label = "Phone:", text = phone.text)
        } else {
            // Edit Mode: Show TextFields
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp))

        Button(onClick = { isEditMode = !isEditMode }) {
            Text(text = if (isEditMode) "Save Details" else "Edit Details")
        }


    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    GrocioTheme {
        ProfileScreen()
    }
}
