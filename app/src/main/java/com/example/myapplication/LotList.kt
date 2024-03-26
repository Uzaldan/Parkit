package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.math.roundToInt


var currentLot="n"
class LotList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotlist)

        val wCardB = findViewById<CardView>(R.id.layoutW);
        val nCardB = findViewById<CardView>(R.id.layoutN);
        val ntCardB = findViewById<CardView>(R.id.layoutNT);
        val t3CardB = findViewById<CardView>(R.id.layoutT3);
        val t1CardB = findViewById<CardView>(R.id.layoutT1);
        val ecCardB = findViewById<CardView>(R.id.layoutEC);
        val etCardB = findViewById<CardView>(R.id.layoutET);
        val mCardB = findViewById<CardView>(R.id.layoutM);
        val hCardB = findViewById<CardView>(R.id.layoutH);
        val whCardB = findViewById<CardView>(R.id.layoutWH);
        val zCardB = findViewById<CardView>(R.id.layoutZ);
        val sCardB = findViewById<CardView>(R.id.layoutS);
        val xtCardB=findViewById<CardView>(R.id.layoutXT)
        wCardB.setOnClickListener{
            currentLot = "w"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)


        }
        nCardB.setOnClickListener{
            currentLot = "n"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        ntCardB.setOnClickListener{
            currentLot = "nt"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        t3CardB.setOnClickListener{
            currentLot = "t3"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        t1CardB.setOnClickListener{
            currentLot = "t1"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        ecCardB.setOnClickListener{
            currentLot = "ec"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        sCardB.setOnClickListener{
            currentLot = "s"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        mCardB.setOnClickListener{
            currentLot = "m"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        hCardB.setOnClickListener{
            currentLot = "h"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        whCardB.setOnClickListener{
            currentLot = "wh"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        etCardB.setOnClickListener{
            currentLot = "et"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        zCardB.setOnClickListener{
            currentLot = "z"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)

        }
        xtCardB.setOnClickListener{
            currentLot = "xt"
            val intent = Intent(this@LotList, LotInfo::class.java)
            startActivity(intent)


        }



    }
    override fun onStart() {
        super.onStart()
        database = Firebase.database.reference;
        var lotSpacesN = findViewById<TextView>(R.id.parkingSpacesN)
        var lotSpacesNT = findViewById<TextView>(R.id.parkingSpacesNT)
        var lotSpacesW = findViewById<TextView>(R.id.parkingSpacesW)
        var lotSpacesWH = findViewById<TextView>(R.id.parkingSpacesWH)
        var lotSpacesS = findViewById<TextView>(R.id.parkingSpacesS)
        var lotSpacesZ = findViewById<TextView>(R.id.parkingSpacesZ)
        var lotSpacesM = findViewById<TextView>(R.id.parkingSpacesM)
        var lotSpacesEC = findViewById<TextView>(R.id.parkingSpacesEC)
        var lotSpacesET = findViewById<TextView>(R.id.parkingSpacesET)
        var lotSpacesT1 = findViewById<TextView>(R.id.parkingSpacesT1)
        var lotSpacesT3 = findViewById<TextView>(R.id.parkingSpacesT3)
        var lotSpacesXT = findViewById<TextView>(R.id.parkingSpacesXT)
        var lotSpacesH = findViewById<TextView>(R.id.parkingSpacesH)
        var lotConditionsN = findViewById<TextView>(R.id.conditionsN)
        var lotConditionsNT = findViewById<TextView>(R.id.conditionsNT)
        var lotConditionsW = findViewById<TextView>(R.id.conditionsW)
        var lotConditionsWH = findViewById<TextView>(R.id.conditionsWH)
        var lotConditionsS = findViewById<TextView>(R.id.conditionsS)
        var lotConditionsZ = findViewById<TextView>(R.id.conditionsZ)
        var lotConditionsM = findViewById<TextView>(R.id.conditionsM)
        var lotConditionsEC = findViewById<TextView>(R.id.conditionsEC)
        var lotConditionsET = findViewById<TextView>(R.id.conditionsET)
        var lotConditionsT1 = findViewById<TextView>(R.id.conditionsT1)
        var lotConditionsT3 = findViewById<TextView>(R.id.conditionsT3)
        var lotConditionsXT = findViewById<TextView>(R.id.conditionsXT)
        var lotConditionsH = findViewById<TextView>(R.id.conditionsH)
        var indicatorN = findViewById<ImageView>(R.id.indicatorN)
        var indicatorNT = findViewById<ImageView>(R.id.indicatorNT)
        var indicatorW = findViewById<ImageView>(R.id.indicatorW)
        var indicatorWH = findViewById<ImageView>(R.id.indicatorWH)
        var indicatorS = findViewById<ImageView>(R.id.indicatorS)
        var indicatorZ = findViewById<ImageView>(R.id.indicatorZ)
        var indicatorM = findViewById<ImageView>(R.id.indicatorM)
        var indicatorEC = findViewById<ImageView>(R.id.indicatorEC)
        var indicatorET = findViewById<ImageView>(R.id.indicatorET)
        var indicatorT1 = findViewById<ImageView>(R.id.indicatorT1)
        var indicatorT3 = findViewById<ImageView>(R.id.indicatorT3)
        var indicatorXT = findViewById<ImageView>(R.id.indicatorXT)
        var indicatorH = findViewById<ImageView>(R.id.indicatorH)


        initConditionsListItem("n",lotConditionsN);
        initConditionsListItem("nt",lotConditionsNT)
        initConditionsListItem("w",lotConditionsW);
        initConditionsListItem("wh",lotConditionsWH)
        initConditionsListItem("s",lotConditionsS);
        initConditionsListItem("z",lotConditionsZ)
        initConditionsListItem("m",lotConditionsM);
        initConditionsListItem("ec",lotConditionsEC)
        initConditionsListItem("et",lotConditionsET);
        initConditionsListItem("t1",lotConditionsT1)
        initConditionsListItem("t3",lotConditionsT3);
        initConditionsListItem("xt",lotConditionsXT)
        initConditionsListItem("h",lotConditionsH);
        initLot("n",null,lotSpacesN,indicatorN)
        initLot("nt",null,lotSpacesNT,indicatorNT)
        initLot("w",null,lotSpacesW,indicatorW)
        initLot("wh",null,lotSpacesWH,indicatorWH)
        initLot("s",null,lotSpacesS,indicatorS)
        initLot("z",null,lotSpacesZ,indicatorZ)
        initLot("m",null,lotSpacesM,indicatorM)
        initLot("ec",null,lotSpacesEC,indicatorEC)
        initLot("et",null,lotSpacesET,indicatorET)
        initLot("t1",null,lotSpacesT1,indicatorT1)
        initLot("t3",null,lotSpacesT3,indicatorT3)
        initLot("xt",null,lotSpacesXT,indicatorXT)
        initLot("h",null,lotSpacesH,indicatorH)








    }

    fun initConditionsListItem(lot:String, Con: TextView) {
        val dbtable = database.child("conditions").child(lot)
        Con.setText("")
        dbtable.child("snow").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Snow") }
        dbtable.child("ice").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Ice") }
        dbtable.child("hail").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Hail") }
        dbtable.child("flooded").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Flooding") }
        dbtable.child("salt").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Salt") }
        dbtable.child("gravel").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Gravel") }
        dbtable.child("potholes").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Potholes") }
        dbtable.child("plowed").get()
            .addOnSuccessListener { addCondition(Con, it.value.toString(), "Plowed") }
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

