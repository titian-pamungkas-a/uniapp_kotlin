package com.example.kotapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var bReview:ImageButton
    private lateinit var bOrder:ImageButton
    private lateinit var bListMakanan:ImageButton
    private lateinit var bQA:ImageButton
    private lateinit var bLogOut : ImageButton
    private lateinit var intents:Intent
    private lateinit var mAUth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAUth = FirebaseAuth.getInstance()
        bReview = findViewById(R.id.bReview)
        bReview.setOnClickListener(operasi)
        bOrder = findViewById(R.id.bDelivery)
        bOrder.setOnClickListener(operasi)
        bListMakanan = findViewById(R.id.bFood)
        bListMakanan.setOnClickListener(operasi)
        bLogOut = findViewById(R.id.bLogout)
        bLogOut.setOnClickListener(operasi)
        bQA = findViewById(R.id.bLokasi)
        bQA.setOnClickListener(operasi)
    }

    override fun onStart() {
        super.onStart()
        var currentUser =mAUth.currentUser
        if (currentUser == null){
            var pindahLogin = Intent(baseContext, Login::class.java)
            startActivity(pindahLogin)
        }
    }

    val operasi = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.bReview -> {
                intents = Intent(applicationContext, Review::class.java)
                startActivity(intents)
            }
            R.id.bLokasi -> {
                intents = Intent(applicationContext, QA::class.java)
                startActivity(intents)
            }
            R.id.bFood -> {
                intents = Intent(applicationContext, ListMakanan::class.java)
                startActivity(intents)
            }
            R.id.bDelivery -> {
                intents = Intent(applicationContext, Order::class.java)
                startActivity(intents)
            }
            R.id.bLogout -> {
                var li : LayoutInflater = LayoutInflater.from(this)
                var input : View = li.inflate(R.layout.logoutkonfirmasi, null)
                var dialog = AlertDialog.Builder(this)
                dialog.setView(input)
                dialog.setCancelable(false);
                dialog.setPositiveButton("ok", DialogInterface.OnClickListener{dialogInterface, i ->
                    mAUth.signOut()
                    var pindahLogin = Intent(baseContext, Login::class.java)
                    startActivity(pindahLogin)
                })
                dialog.setNegativeButton("batal", DialogInterface.OnClickListener{dialogInterface, i ->

                })
                dialog.show();
            }
            else -> {}
        }

    }





    //override fun View.OnClickListener


}
