package com.example.grocio.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.grocio.ui.theme.GrocioTheme

@Composable
fun Dashboard(navController: NavController?){

    Column(modifier = Modifier.fillMaxSize()) {

    }

}

@Preview(showBackground = true)
@Composable
fun Dashboard() {
    GrocioTheme {
        Dashboard(navController = null)
    }
}
