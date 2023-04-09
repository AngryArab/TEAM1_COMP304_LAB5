package com.example.team1_comp304_lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignUpActivity : AppCompatActivity() {

    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText
    private lateinit var signUpBtn : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        signUpBtn = findViewById(R.id.signupBtn)

        signUpBtn.setOnClickListener{
            createUser()
        }



    }
}