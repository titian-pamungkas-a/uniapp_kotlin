package com.example.kotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Register : AppCompatActivity() {

    private lateinit var name :EditText
    private lateinit var user :EditText
    private lateinit var pass :EditText
    private lateinit var hp :EditText
    private lateinit var alamat :EditText
    private lateinit var daftar :Button
    private lateinit var mAuth :FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        name = findViewById(R.id.namauser)
        user = findViewById(R.id.usernameuser)
        pass = findViewById(R.id.passworduser)
        hp = findViewById(R.id.nohpuser)
        alamat = findViewById(R.id.alamatuser)
        daftar = findViewById(R.id.daftarButton)
        mAuth = FirebaseAuth.getInstance()
        daftar.setOnClickListener(View.OnClickListener {
            view ->
            mAuth.createUserWithEmailAndPassword(user.text.toString().trim(), pass.text.toString().trim())
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        Toast.makeText(baseContext, "Login berhasil", Toast.LENGTH_LONG).show()
                        val UserID  = mAuth.currentUser
                        if (UserID != null) {
                            pindahMain(UserID)
                        }
                    }else{
                        Toast.makeText(baseContext, "Login gagal", Toast.LENGTH_LONG).show()
                        Log.e("AUTH", "Error signing in", task.exception);
                    }
                }
        })
    }

    fun pindahMain(userID: FirebaseUser) {
        var pindahMenu = Intent(baseContext, MainActivity::class.java)
        startActivity(pindahMenu)
    }

}