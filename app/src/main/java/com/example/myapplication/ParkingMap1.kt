package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ParkingMap1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parkingmap);
        val wCardB = findViewById<Button>(R.id.w_mapButton);
        val nCardB = findViewById<Button>(R.id.n_mapButton);
        val ntCardB = findViewById<Button>(R.id.nt_mapButton);
        val t3CardB = findViewById<Button>(R.id.t3_mapButton);
        val t1CardB = findViewById<Button>(R.id.t1_mapButton);
        val ecCardB = findViewById<Button>(R.id.ec_mapButton);
        val etCardB = findViewById<Button>(R.id.et_mapButton);
        val mCardB = findViewById<Button>(R.id.m_mapButton);
        val hCardB = findViewById<Button>(R.id.h_mapButton);
        val whCardB = findViewById<Button>(R.id.wh_mapButton);
        val zCardB = findViewById<Button>(R.id.z_mapButton);
        val sCardB = findViewById<Button>(R.id.s_mapButton);
        wCardB.setOnClickListener{
            currentLot="w"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        nCardB.setOnClickListener{
            currentLot="n"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        ntCardB.setOnClickListener{
            currentLot="nt"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        t3CardB.setOnClickListener{
            currentLot="t3"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        t1CardB.setOnClickListener{
            currentLot="t1"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        ecCardB.setOnClickListener{
            currentLot="ec"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        sCardB.setOnClickListener{
            currentLot="s"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        mCardB.setOnClickListener{
            currentLot="m"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        hCardB.setOnClickListener{
            currentLot="h"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        whCardB.setOnClickListener{
            currentLot="wh"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        etCardB.setOnClickListener{
            currentLot="et"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
        zCardB.setOnClickListener{
            currentLot="z"
            val intent = Intent(this@ParkingMap1, LotInfo::class.java)
            startActivity(intent)

        }
    }
    override fun onStart() {
        super.onStart()
        database = Firebase.database.reference;
        val wCardB = findViewById<Button>(R.id.w_mapButton);
        val nCardB = findViewById<Button>(R.id.n_mapButton);
        val ntCardB = findViewById<Button>(R.id.nt_mapButton);
        val t3CardB = findViewById<Button>(R.id.t3_mapButton);
        val t1CardB = findViewById<Button>(R.id.t1_mapButton);
        val ecCardB = findViewById<Button>(R.id.ec_mapButton);
        val etCardB = findViewById<Button>(R.id.et_mapButton);
        val mCardB = findViewById<Button>(R.id.m_mapButton);
        val hCardB = findViewById<Button>(R.id.h_mapButton);
        val whCardB = findViewById<Button>(R.id.wh_mapButton);
        val zCardB = findViewById<Button>(R.id.z_mapButton);
        val sCardB = findViewById<Button>(R.id.s_mapButton);
        setButtonColour("w",wCardB)
        setButtonColour("n",nCardB)
        setButtonColour("nt",ntCardB)
        setButtonColour("t3",t3CardB)
        setButtonColour("t1",t1CardB)
        setButtonColour("z",zCardB)
        setButtonColour("s",sCardB)
        setButtonColour("h",hCardB)
        setButtonColour("m",mCardB)
        setButtonColour("wh",whCardB)
        setButtonColour("ec",ecCardB)
        setButtonColour("et",etCardB)




    }

    fun setButtonColour( lot:String,button: Button){
        val dbtable = database.child("parkinglots").child(lot)
        dbtable.child("percent").get().addOnSuccessListener {
                var thing = it.value.toString()

                if (thing.toInt()<=50)
            button.setBackgroundResource(R.drawable.circle_button)
            else if(thing.toInt()<=75)
                    button.setBackgroundResource(R.drawable.circle_buttonyellow)
                                else
                    button.setBackgroundResource(R.drawable.circle_buttonred)
        }

    }
}

