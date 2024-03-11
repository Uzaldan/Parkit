package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainactivity)
        val lotListB = findViewById<Button>(R.id.lotListButton)
        val mapB = findViewById<Button>(R.id.mapButton)
        val subInfoB = findViewById<Button>(R.id.submitInfoButton)
       // val B= findViewById<Button>(R.id.)
       // val B= findViewById<Button>(R.id.)
        //val B= findViewById<Button>(R.id.)
       // val B= findViewById<Button>(R.id.)
       // val B= findViewById<Button>(R.id.)
        subInfoB.setOnClickListener{
            setContentView(R.layout.activity_lotlist)
        }
        lotListB.setOnClickListener{
            setContentView(R.layout.activity_lotlist)
        }
        mapB.setOnClickListener{
            setContentView(R.layout.activity_lotinfo)
        }

    }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}