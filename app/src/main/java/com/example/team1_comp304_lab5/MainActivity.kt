package com.example.team1_comp304_lab5

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var enter: Button
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        enter.findViewById<Button>(R.id.enter)

        enter.setOnClickListener{
            val intent = Intent(this@MainActivity,SignUpActivity::class.java)
            startActivity(intent)
        }





        val database = Firebase.database
        val myRef = database.getReference("message")

        //new ref
        val newRef = database.getReference("messagse")

        // pushing and setting into the database
        myRef.setValue("Hello, yhhh!")
        myRef.push().setValue("Hello moezbi")

        newRef.push().setValue("new ref testet")

        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<HashMap<String,String>>()
                Log.d(TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })


    }






}