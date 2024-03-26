package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
import org.w3c.dom.Comment

class Feedback : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
    }
    override fun onStart(){
        super.onStart()
        var comment= findViewById<EditText>(R.id.feedBackComment)
        var email =findViewById<EditText>(R.id.userEmailAddress)
        var submitB = findViewById<Button>(R.id.submitfeedback)
        submitB.setOnClickListener(){
            submitMessage(email.text.toString(), comment.text.toString())
            val intent = Intent(this@Feedback, MainActivity::class.java)
            startActivity(intent)
        }

    }
fun submitMessage(email:String,comment: String) {
    var hold = email.split('@')
   val dbtable = database.child("comments").child(hold[0])
    dbtable.child("comment").setValue(comment).addOnSuccessListener { Log.i("firebase", "set value {$it}") }
        .addOnFailureListener() {
            Log.e("firebase", "Error getting data", it)
        }
}
}

