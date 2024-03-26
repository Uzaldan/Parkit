package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.math.roundToInt




class LotInfo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lotinfo)
        val updateB = findViewById<Button>(R.id.LI_Update_button);
        updateB.setOnClickListener() {
            val intent = Intent(this@LotInfo, EditLot::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        database = Firebase.database.reference;
        val mainCon = findViewById<TextView>(R.id.focLotMainCon)
        val weatherCon = findViewById<TextView>(R.id.focLotWeathCon)
        val lotName = findViewById<TextView>(R.id.lotName)
        val lotSpaces = findViewById<TextView>(R.id.lotSpaces)
        initLot(currentLot, lotName, lotSpaces,null);
        initConditions(currentLot, weatherCon, mainCon);

    }



    fun initConditions(lot: String, weathCon: TextView, maintCon: TextView) {
        val dbtable = database.child("conditions").child(lot)
        weathCon.setText("");
        maintCon.setText("")
        dbtable.child("snow").get()
            .addOnSuccessListener { addCondition(weathCon, it.value.toString(), "Snow") }
        dbtable.child("ice").get()
            .addOnSuccessListener { addCondition(weathCon, it.value.toString(), "Ice") }
        dbtable.child("hail").get()
            .addOnSuccessListener { addCondition(weathCon, it.value.toString(), "Hail") }
        dbtable.child("flooded").get()
            .addOnSuccessListener { addCondition(weathCon, it.value.toString(), "Flooding") }
        dbtable.child("salt").get()
            .addOnSuccessListener { addCondition(maintCon, it.value.toString(), "Salt") }
        dbtable.child("gravel").get()
            .addOnSuccessListener { addCondition(maintCon, it.value.toString(), "Gravel") }
        dbtable.child("potholes").get()
            .addOnSuccessListener { addCondition(maintCon, it.value.toString(), "Potholes") }
        dbtable.child("plowed").get()
            .addOnSuccessListener { addCondition(maintCon, it.value.toString(), "Plowed") }

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


}




