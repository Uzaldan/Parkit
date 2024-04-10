package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.timer
import kotlin.reflect.typeOf


class EditLot : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_editlot)

    }
    override fun onStart(){
        database = Firebase.database.reference;
        val dbtable = database.child("conditions").child(currentLot)
        super.onStart()
        val snowcbx = findViewById<CheckBox>(R.id.snowBox)
        val potholcbx = findViewById<CheckBox>(R.id.potBox)
        val saltcbx = findViewById<CheckBox>(R.id.saltBox)
        val gravelcbx = findViewById<CheckBox>(R.id.gravelBox)
        val icecbx = findViewById<CheckBox>(R.id.iceBox)
        val plowcbx = findViewById<CheckBox>(R.id.plowBox)
        val floodcbx = findViewById<CheckBox>(R.id.floodBox)
        val hailcbx = findViewById<CheckBox>(R.id.hailBox)
        val lotPercent = findViewById<Spinner>(R.id.lotPercent)
        val editLotName = findViewById<TextView>(R.id.editLotName)

        editLotName.setText("Lot $currentLot")


         //snowcbx.isChecked =
       updateData( arrayOf(potholcbx,gravelcbx,snowcbx,saltcbx,icecbx,plowcbx,floodcbx),
           arrayOf("potholes","gravel","snow","salt","ice","plowed","flooded","hail")
       );
        initPercent(lotPercent)

        //gravelcbx.isChecked = dbtable.child("gravel").get().result.value==true;
        //saltcbx.isChecked = dbtable.child("salt").get().result.value==true;
       // icecbx.isChecked = dbtable.child("ice").get().result.value==true;
       // plowcbx.isChecked = dbtable.child("salt").get().result.value==true;
        //floodcbx.isChecked = false;
       // hailcbx.isChecked = false;
        var bool = arrayOf(
            snowcbx.isChecked(),
            potholcbx.isChecked(),
            saltcbx.isChecked(),
            gravelcbx.isChecked(),
            icecbx.isChecked(),
            plowcbx.isChecked(),
            floodcbx.isChecked(),
            hailcbx.isChecked()
        )
        val updateB = findViewById<Button>(R.id.editButton);

        updateB.setOnClickListener() {
            var thing = lotPercent.selectedItem.toString().trim('%').toInt()
            bool = arrayOf(snowcbx.isChecked, potholcbx.isChecked, saltcbx.isChecked,gravelcbx.isChecked,icecbx.isChecked,plowcbx.isChecked,floodcbx.isChecked,hailcbx.isChecked)
            changeData(bool, arrayOf("snow","potholes","salt","gravel","ice","plowed","flooded","hail"));
            changePercent(thing)
            //updateconditions(currentLot,bool);
            //updatelot(currentLot,)
            val intent = Intent(this@EditLot, MainActivity::class.java)
            startActivity(intent)

        }


    }
}
fun updateData(tar: Array<CheckBox>,dbTar: Array<String>) = runBlocking {
    var i = 0;
    val dbtable = database.child("conditions").child(currentLot)
    for (thing in tar) {
        dbtable.child(dbTar[i]).get().addOnSuccessListener { setValues(it.value, thing); }
            .addOnFailureListener() {
                Log.e("firebase", "Error getting data", it)
            }
        i += 1;
    }
}
fun changeData(tar: Array<Boolean>,dbTar: Array<String>) = runBlocking {
    var i = 0;
    val dbtable = database.child("conditions").child(currentLot)
    for (thing in tar) {
        dbtable.child(dbTar[i]).setValue(thing).addOnSuccessListener { Log.i("firebase", "set value") }
            .addOnFailureListener() {
                Log.e("firebase", "Error getting data", it)
            }
        i += 1;
    }
}
fun changePercent(value: Number) = runBlocking {
    val dbtable = database.child("parkinglots").child(currentLot)

        dbtable.child("percent").setValue(value).addOnSuccessListener { Log.i("firebase", "set value {$value}") }
        .addOnFailureListener() {
            Log.e("firebase", "Error getting data", it)
        }
}
fun initPercent(tar:Spinner) = runBlocking {
    val dbtable = database.child("parkinglots").child(currentLot)
    dbtable.child("percent").get().addOnSuccessListener { setPercent(it.value, tar) }
        .addOnFailureListener() {
            Log.e("firebase", "Error getting data", it)
        }
}

fun setPercent(value: Any?, tar: Spinner){
    var values=(value).toString()
    println()
    if(values=="0"){
        tar.setSelection(0);
    }
    else if(values=="25"){
        tar.setSelection(1);
    }
    else if(values=="50"){
        tar.setSelection(2);
    }
    else if(values=="75"){
        tar.setSelection(3);
    }
    else if(values=="100"){
        tar.setSelection(4);
    }
    else
        tar.setSelection(4);
}



fun setValues(value:Any?,tar: CheckBox){
 tar.isChecked = value==true;
}
