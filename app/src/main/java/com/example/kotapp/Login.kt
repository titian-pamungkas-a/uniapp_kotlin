package com.example.kotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Login : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var login : Button
    private lateinit var username : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login = findViewById(R.id.loginButton)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        mAuth = FirebaseAuth.getInstance()
        login.setOnClickListener(View.OnClickListener {
            view ->
            mAuth.signInWithEmailAndPassword(username.text.toString().trim(), password.text.toString().trim())
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        val user = mAuth.currentUser
                        var pindahMenu = Intent(baseContext, MainActivity::class.java)
                        startActivity(pindahMenu)
                    }else{
                        Toast.makeText(baseContext, "Email atau password yang anda masukkan salah, silahkan coba lagi", Toast.LENGTH_LONG).show()

                    }
                }
        })

    }

    fun PindahRegister(view: View) {
        var pindahRegister = Intent(baseContext, Register::class.java)
        startActivity(pindahRegister)
    }

}