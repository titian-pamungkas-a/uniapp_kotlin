package com.example.kotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListMakanan : AppCompatActivity() , listInterface{

    private lateinit var lv:ListView
    private lateinit var mAdapter:makananAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_makanan)
        lv = findViewById(R.id.list)
        var listnama = ArrayList<Lauk>()
        mAdapter = makananAdapter(this, 0, listnama, this)
        lv.adapter = mAdapter
        addLauk("Rendang", 20000, "Nikmati rendang dari daging sapi pilihan", R.drawable.rendang1,
            "Rendang adalah makanan khas dari Sumatera barat yang menggunakan daging sapi sebagai bahan dasar. Rendang yang kami buat menggunakan daging sapi pilihan dan dimasak tanpa menggunakan minyak dalam waktu yang lama, sehingga daging yang dihasilkan beraroma sedap dan tekstur yang lembut.")
        addLauk("Ayam Kare", 18000, "Ayam kare dengan bumbu turun temurun siap membuat anda ketagihan", R.drawable.ayamkare,
            "Ayam kare adalah pasangan terbaik untuk menikmati nasi padang. Rempah yang digunakan merupakan resep turun temurun sehingga racikannya tidak perlu diragukan. Ayam yang digunakan merupakan ayam pedaging berkualitas tinggi sehingga memberikan daging yang lembut.")
        addLauk("Perkedel", 15000, "Isi perutmu dengan olahan kentang yang lembut", R.drawable.bedel,
            "Perkedel adalah lauk yang menggunakan sebagai kentang sebagai bahan dasar. Kentang yang kami gunakan merupakan kentang terbaik yang diproduksi oleh kebun yang terpercaya. Kentang memiliki banyak mafaat seperti membuat kenyang.")
        addLauk("Telur dadar", 15000, "Lengkali gizimu dengan telur yang berkualitas", R.drawable.endog,
            "Telur Dadar yang dibuat menggunakan berbagai bumbu tambahan cocok dikonsumsi sebagai tambahan. Dengan bawang dan campuran cabai terpilih membuat telur yang dibuat memiliki rasa yang bervariasi.")
        addLauk("Ikan Balado", 24000, "Kelezatan ikan yang segar dengan bumbu Balado ayng menggoda", R.drawable.ikan,
            "Ikan Balado menggunakan Ikan tenggiri yang dibudidayakan secara alami dan dipanen dengan cara yang tepat sehingga didapat ikan yang segar. Dibumbui dengan bumbu balado hasil dari turun temurun, siap untuk menemani anda untuk menikmati nasi padang.")

    }

    private fun addLauk(s: String, i: Int, s1: String, i1: Int, s2: String) {
        var laukbaru = Lauk(s, s1, s2, i, i1)
        mAdapter.add(laukbaru)
    }

    override fun tampilkanDetail(p: Lauk) {
        var newintent = Intent(baseContext, Ingfo::class.java)
        newintent.putExtra("name", p.namaLauk);
        newintent.putExtra("gambar", p.gambar);
        newintent.putExtra("harga", p.harga);
        newintent.putExtra("deskripsi", p.detail);
        startActivity(newintent)
    }
}

//    private val inama = arrayOf("Rendang", "Ayam Kare", "Perkedel", "Telur dadar", "Ikan balado")
//    private val iharga = arrayOf(20000, 18000, 15000, 15000, 24000)
//    private val iketerangan = arrayOf("Nikmati rendang dari daging sapi pilihan",
//        "Ayam kare dengan bumbu turun temurun siap membuat anda ketagihan",
//        "Isi perutmu dengan olahan kentang yang lembut",
//        "Lengkali gizimu dengan telur yang berkualitas",
//        "Kelezatan ikan yang segar dengan bumbu Balado ayng menggoda")
//    private val igambar = arrayOf(R.drawable.rendang1, R.drawable.ayamkare, R.drawable.bedel, R.drawable.endog, R.drawable.ikan)
//    private val idetail = arrayOf("Rendang adalah makanan khas dari Sumatera barat yang menggunakan daging sapi sebagai bahan dasar. Rendang yang kami buat menggunakan daging sapi pilihan dan dimasak tanpa menggunakan minyak dalam waktu yang lama, sehingga daging yang dihasilkan beraroma sedap dan tekstur yang lembut.",
//        "Ayam kare adalah pasangan terbaik untuk menikmati nasi padang. Rempah yang digunakan merupakan resep turun temurun sehingga racikannya tidak perlu diragukan. Ayam yang digunakan merupakan ayam pedaging berkualitas tinggi sehingga memberikan daging yang lembut.",
//        "Perkedel adalah lauk yang menggunakan sebagai kentang sebagai bahan dasar. Kentang yang kami gunakan merupakan kentang terbaik yang diproduksi oleh kebun yang terpercaya. Kentang memiliki banyak mafaat seperti membuat kenyang.",
//        "Telur Dadar yang dibuat menggunakan berbagai bumbu tambahan cocok dikonsumsi sebagai tambahan. Dengan bawang dan campuran cabai terpilih membuat telur yang dibuat memiliki rasa yang bervariasi.",
//        "Ikan Balado menggunakan Ikan tenggiri yang dibudidayakan secara alami dan dipanen dengan cara yang tepat sehingga didapat ikan yang segar. Dibumbui dengan bumbu balado hasil dari turun temurun, siap untuk menemani anda untuk menikmati nasi padang.")
