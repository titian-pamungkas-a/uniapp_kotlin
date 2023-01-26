package com.example.kotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class Order : AppCompatActivity(), detailInterface{

    private lateinit var lv : ListView
    private lateinit var oAdapter : orderAdapter
    private lateinit var totalView : TextView
    private lateinit var beli : Button
    private lateinit var listnama : ArrayList<OrderMakanan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        lv = findViewById(R.id.listOrder)
        totalView = findViewById(R.id.total)
        beli = findViewById(R.id.beli)
        listnama = ArrayList<OrderMakanan>()
        oAdapter = orderAdapter(this, 0, listnama, this)
        lv.adapter = oAdapter
        addOrder("Rendang", 20000, "0", 0, R.drawable.rendang1);
        addOrder("Ayam Kare", 18000, "0", 1, R.drawable.ayamkare);
        addOrder("Perkedel", 15000, "0", 2, R.drawable.bedel);
        addOrder("Telur Dadar", 15000, "0", 3, R.drawable.endog);
        addOrder("Ikan Balado", 24000, "0", 4, R.drawable.ikan);
        beli.setOnClickListener(View.OnClickListener {
            view ->
            if (totalView.text == "Rp0") Toast.makeText(baseContext, "Jangan beli", Toast.LENGTH_SHORT).show()
            else {
                Toast.makeText(baseContext, "Beli", Toast.LENGTH_SHORT).show()
                var pindahMap = Intent(baseContext, MapsActivity::class.java)
                startActivity(pindahMap)
            }
        })
    }

    private fun addOrder(s: String, i: Int, s1: String, i1: Int, i2: Int) {
        var baru = OrderMakanan(s1, i, i1, s, i2)
        oAdapter.add(baru)
    }

    override fun addItem(position: OrderMakanan, pos: String) {
        var value = 0
        var total = 0
        while (listnama.size > value){
            var mak1 = listnama.get(value)
            total += mak1.jumlah.toInt() * mak1.harga
            value++
        }
        totalView.setText("Rp"+total)
    }

}