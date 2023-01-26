package com.example.kotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Ingfo : AppCompatActivity() {

    private lateinit var judul:TextView
    private lateinit var harga:TextView
    private lateinit var deskripsi:TextView
    private lateinit var gambar:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingfo)
        judul = findViewById(R.id.JudulText)
        harga = findViewById(R.id.HargaText)
        deskripsi = findViewById(R.id.DeskripsiText)
        gambar = findViewById(R.id.JudulGambar)
        judul.setText(intent.getStringExtra("name"))
        harga.setText("Harga : Rp" + intent.getIntExtra("harga", 0).toString())
        deskripsi.setText(intent.getStringExtra("deskripsi"))
        var gambarsrc:Int = intent.getIntExtra("gambar", 0)
        gambar.setImageResource(gambarsrc)
    }
}