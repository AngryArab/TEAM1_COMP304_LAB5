package com.example.team1_comp304_lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var authenticate : FirebaseAuth
    private lateinit var etemail : EditText
    private lateinit var etPassword : EditText
    private lateinit var signUpBtn : Button

    private val tag  = "Firebase_Auth_SignUp"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        etemail = findViewById(R.id.et_emailsignup)
        etPassword = findViewById(R.id.et_password)
        signUpBtn = findViewById(R.id.signupBtn)

        signUpBtn.setOnClickListener{


        }



    }

    fun CreateUser(){
        val email = etemail.text.toString()
        val password = etPassword.text.toString()

        if(TextUtils.isEmpty(email)){
            etemail.error = "This field can not be empty"
            etemail.requestFocus()
        } else if (TextUtils.isEmpty(password)){
            etPassword.error = "This field can not be empty"

        } else{
            authenticate.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {
                    task -> if(task.isSuccessful){
                        Toast.makeText(this@SignUpActivity,"Sign up successful",Toast.LENGTH_SHORT).show()


                    val intent = Intent(this@SignUpActivity,LogInActivity::class.java)
                    startActivity(intent)
                } else{

                    Toast.makeText(baseContext,"Authentication failed",Toast.LENGTH_SHORT).show()
                }
                }
        }



    }
















}