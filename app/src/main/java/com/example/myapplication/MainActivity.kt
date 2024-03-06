package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
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
        val txtview: TextView  = findViewById(R.id.textView);
        txtview.text= ("PIS");
        val mapbutton: TextView  = findViewById(R.id.button1);
        mapbutton.text= ("Map");
        val lotButton: TextView  = findViewById(R.id.button);
        lotButton.text= ("Lot List");
        val favButton: TextView  = findViewById(R.id.button2);
        favButton.text= ("Favorites");
        mapbutton.setOnClickListener{

            startActivity(Intent(this, Parking_map::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply`

            })
        }
        lotButton.setOnClickListener{
            Toast.makeText(this@MainActivity, "Hi lots!", Toast.LENGTH_SHORT).show()
        }
        favButton.setOnClickListener{
            Toast.makeText(this@MainActivity, "Hi favs!", Toast.LENGTH_SHORT).show()
            favButton.text= ("bean button");
        }
        //button3.setOnClickListener{
//
  //      }
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