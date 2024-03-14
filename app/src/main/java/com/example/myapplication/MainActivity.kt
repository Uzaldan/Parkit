package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
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
        val items = arrayOf("25%", "50%", "75%", "100%")
        val feedbackB = findViewById<Button>(R.id.feedbackButton)
       // val B= findViewById<Button>(R.id.)
       // val B= findViewById<Button>(R.id.)
        //val B= findViewById<Button>(R.id.)
        //val mapB= findViewById<Button>(R.id.mapButton)
        var hashMap : HashMap<String, Int> = HashMap<String, Int> ()
        hashMap.put("" , 3000)

        mapB.setOnClickListener{
            setContentView(R.layout.activity_parkingmap)

        }

      feedbackB.setOnClickListener{
          setContentView(R.layout.activity_feedback)

      }
        lotListB.setOnClickListener{
            setContentView(R.layout.activity_lotlist)

            val cardkl = findViewById<CardView>(R.id.layoutW)
            val carda = findViewById<CardView>(R.id.layoutNT)
            val cardb = findViewById<CardView>(R.id.layoutN)
            val cardc = findViewById<CardView>(R.id.layoutM)
            val cardd = findViewById<CardView>(R.id.layoutH)
            val cardEC = findViewById<CardView>(R.id.layoutEC) .setOnClickListener{
                    setContentView(R.layout.activity_lotinfo)
                    val updateB= findViewById<Button>(R.id.LI_Update_button)
                    updateB.setOnClickListener{
                        setContentView(R.layout.activity_editlot)
                    }

                }
        }
        mapB

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