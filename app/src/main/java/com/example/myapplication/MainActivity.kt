package com.example.myapplication

import Conditions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.math.roundToInt

public lateinit var database: DatabaseReference


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainactivity)
        database = Firebase.database.reference


            val lotListB = findViewById<Button>(R.id.lotListButton)
        val mapB = findViewById<Button>(R.id.mapButton)

        val feedbackB = findViewById<Button>(R.id.feedbackButton)



        mapB.setOnClickListener{
            val intent = Intent(this@MainActivity, ParkingMap1::class.java)
            startActivity(intent)

        }

      feedbackB.setOnClickListener{
          val intent = Intent(this@MainActivity, Feedback::class.java)
          startActivity(intent)

      }
        lotListB.setOnClickListener{
            val intent = Intent(this@MainActivity, LotList::class.java)
            startActivity(intent)


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

fun updateconditions(name: String, array: Array<Boolean>){
   var dbclot = database.child("conditions").child(name);
   var setConditions = Conditions(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7]);
   var setConValues = setConditions.toMap();
    dbclot.updateChildren(setConValues);
}
fun updatelot(name: String, percent:Number){
    var dblot = database.child("conditions").child(name);
    dblot.child("percent").setValue(percent);

}
fun  addCondition(con: TextView, value:Any?, seleCondition:String){
    var hold = con.text;
    if (value=="true")
        con.setText("$hold $seleCondition,")
}
fun initLot(lot:String, lotName: TextView?, lotSpaces: TextView, indicator: ImageView?){
    val dbtable = database.child("parkinglots").child(lot)
    dbtable.child("percent").get().addOnSuccessListener { calcLots(it.value.toString(),lot,lotName,lotSpaces,indicator) }

}
fun calcLots(thing:String,lot:String,lotName: TextView?,lotSpaces: TextView,indicator: ImageView?) {
    var hold = thing.toInt()
    if (thing.toInt()<50)
        indicator?.setImageResource(R.color.brightGreen)
    else if (thing.toInt()<75)
        indicator?.setImageResource(R.color.brightYellow)
    else
        indicator?.setImageResource(R.color.brightRed)
    val dbtable = database.child("parkinglots").child(lot)
    dbtable.child("spaces").get().addOnSuccessListener {
        setLot(it.value.toString(),lot,lotName,lotSpaces,hold)
    }
}
fun setLot(value:String,lot: String,lotName: TextView?, lotSpaces: TextView,percent:Number){
    val lotupper =lot.uppercase()
    lotName?.setText("Lot $lotupper");
    var hold = value.toInt() - (value.toInt() * percent.toFloat()/100).roundToInt()
    lotSpaces.setText("$hold/$value")


}


