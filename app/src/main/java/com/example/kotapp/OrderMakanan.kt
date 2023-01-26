package com.example.kotapp

import android.widget.ImageButton

class OrderMakanan {
    var jumlah : String
    var harga : Int
    var posisi : Int
    var nama : String
    lateinit var min : ImageButton
    lateinit var max : ImageButton
    var gambar : Int

    constructor(
        jumlah: String,
        harga: Int,
        posisi: Int,
        nama: String,
        gambar: Int
    ) {
        this.jumlah = jumlah
        this.harga = harga
        this.posisi = posisi
        this.nama = nama
        this.gambar = gambar
    }
}