package com.example.kotapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Review : AppCompatActivity() {
    private lateinit var db : FirebaseFirestore
    private lateinit var bKirim : Button
    private lateinit var tulisReview: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        db = FirebaseFirestore.getInstance()
        bKirim = findViewById(R.id.kirimReview)
        tulisReview = findViewById(R.id.fillReview)
        bKirim.setOnClickListener(View.OnClickListener {
            view ->
            if (tulisReview.text.toString() == ""){
                Toast.makeText(baseContext, "Isi review terlebih dahulu", Toast.LENGTH_LONG).show()
            }else {
                val userReview : HashMap<String, String> = hashMapOf("Review" to tulisReview.text.toString())
                db.collection("Users").add(userReview)
            }
        })
    }
}