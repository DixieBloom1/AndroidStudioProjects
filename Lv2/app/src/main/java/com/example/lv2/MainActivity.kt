package com.example.lv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lv2.ui.theme.Lv2Theme
import com.example.lv2.ui.theme.customFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lv2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BackgroundImage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UserPreview(name: String, visina: Float, tezina: Float, modifier: Modifier = Modifier) {
    val bmi = tezina / (visina * visina)
    val formattedBmi = String.format("%.2f", bmi)
    val bmiColor = if (bmi < 20) Color.Green else Color.Red

    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Pozdrav $name!",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp).align(Alignment.TopStart),
            fontFamily = customFont
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 70.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 40.dp)
            ) {
                Text(text = "Visina: ${"%.2f".format(visina)} m", fontSize = 18.sp, fontFamily = customFont)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Težina: ${tezina} kg", fontSize = 18.sp, fontFamily = customFont)
            }

            Text(
                text = "Tvoj BMI je:",
                fontSize = 55.sp,
                lineHeight = 61.sp,
                modifier = Modifier.padding(top = 40.dp),
                fontFamily = customFont
            )
            Text(
                text = formattedBmi,
                fontSize = 70.sp,
                lineHeight = 72.sp,
                fontWeight = FontWeight.Bold,
                color = bmiColor,
                fontFamily = customFont
            )
        }
    }
}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.4f
        )

        UserPreview(
            name = "Miljenko",
            visina = 2.1f,
            tezina = 80f,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Lv2Theme {
        BackgroundImage()
    }
}
