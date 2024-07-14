package com.example.buildbasiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.buildbasiclayout.ui.theme.BuildBasicLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //entry point to this Android app and calls other functions to build the user interface.
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {    //used to define your layout through composable functions.
            BuildBasicLayoutTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                Surface (   //a container that represents a section of UI where you can alter the appearance, such as the background color or border.
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    GreetingImage(message = "Happy Birthday Sam!", from = "from Emma")
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    Column {
        Text(text = message, fontSize = 100.sp, lineHeight = 116.sp)
        Text(text = from, fontSize = 36.sp)
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(painter = image, contentDescription = null)
        GreetingText(message = message, from = from)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "Build Basic Layout")

@Composable
fun GreetingPreview() {
    BuildBasicLayoutTheme {
        GreetingImage(message = "Happy Birthday Sam!", from = "from Emma")
    }
}