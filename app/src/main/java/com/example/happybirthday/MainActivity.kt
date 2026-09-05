package com.example.happybirthday


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //TODO:
        //Cómo agregar imágenes a tu app para Android
        // https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables#4
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                         name = "Android",
                         modifier = Modifier.padding(innerPadding)
                     )
                 }*/

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*GreetingText(
                        "Happy Birthday Enny",
                        "From Mami",
                        modifier = Modifier.padding(8.dp)
                    )*/
                    GreetingImage(message="Happy Birthday Enny!",from="From Mami")
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

@Preview(
    showBackground = true,
    // backgroundColor = 0xff334455,
    name = "Mi preview"/*,
    showSystemUi = true*/
)
//@Preview
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        // Greeting("Encarna")
       // GreetingText(message = "Happy Birthday Encarna!", from = "From Emma")
       GreetingImage(message = "Happy Birthday Encarna", from="From mami")
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier,textColor: Color) {
    /*  Row (modifier=modifier){
          Text(
              text = message,
             // fontSize = 100.sp,
              fontSize = 30.sp,
              lineHeight = 116.5.sp
          )
          Text(
              text = from,
              fontSize = 36.sp
          )
      }*/

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            //fontSize = 30.sp,
            lineHeight = 116.5.sp,
            textAlign = TextAlign.Center,
            color = textColor


        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End),
            color=textColor
        )
    }


}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Image(
        painter = image,
        null,
        /* Commit9-a: escalar imagen y cambio opacidad*/
        contentScale = ContentScale.Crop,
        alpha = 0.5F
    )

    GreetingText(
        message=message,
        from=from,
        modifier=Modifier.fillMaxSize().padding(8.dp),
        textColor=Color.Green
              /*  Commit9-b:  Cambio del color de texto  */
    )
}