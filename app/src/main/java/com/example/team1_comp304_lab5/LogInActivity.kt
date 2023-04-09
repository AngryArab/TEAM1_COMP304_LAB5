package com.example.team1_comp304_lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInActivity : AppCompatActivity() {

    private lateinit var etemail : EditText
    private lateinit var etpassword:EditText
    private lateinit var authenticate : FirebaseAuth
    private lateinit var signin:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        authenticate = Firebase.auth

        etemail = findViewById(R.id.et_loginusername)
        etpassword = findViewById(R.id.et_loginpassword)
        signin = findViewById(R.id.loginBtn)

        signin.setOnClickListener{
            AttemptLogin()


        }





    }

    private fun AttemptLogin(){
        val email = etemail.text.toString()
        val pasword = etpassword.text.toString()


        if(TextUtils.isEmpty(email)){
            etemail.error = "can not be empty"
            etemail.requestFocus()
        } else if (TextUtils.isEmpty(pasword)){
            etpassword.error = "can not be empty"
            etpassword.requestFocus()

        } else{
            authenticate.signInWithEmailAndPassword(email,pasword)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){

                        val user = authenticate.currentUser

                        val intent = Intent(this@LogInActivity,MedicineActivity::class.java)

                    } else {
                        Toast.makeText(baseContext,"auth failed",Toast.LENGTH_SHORT).show()
                    }
                }
        }












    }







}