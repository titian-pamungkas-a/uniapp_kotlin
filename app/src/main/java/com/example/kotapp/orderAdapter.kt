package com.example.kotapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class orderAdapter : ArrayAdapter<OrderMakanan> {
    private var detail : detailInterface
    constructor(context: Context, resource: Int, listnama: ArrayList<OrderMakanan>, detail : detailInterface) : super(context, resource, listnama){
        this.detail = detail
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var myOrder : OrderMakanan = getItem(position)!!
        var convertView = convertView
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.orderlayout, parent, false)
        }
        var tNama : TextView = convertView!!.findViewById(R.id.tnamaorder)
        var tHarga : TextView = convertView.findViewById(R.id.tharga)
        var min : ImageButton = convertView.findViewById(R.id.min)
        var max : ImageButton = convertView.findViewById(R.id.max)
        var gambar : ImageView = convertView.findViewById(R.id.tgambarorder)
        var jumlah : TextView = convertView.findViewById(R.id.jumlahView)
        min.setOnClickListener(View.OnClickListener {
            view ->
            var number = myOrder.jumlah.toInt() - 1;
            if (number <= 0 ) number = 0
            myOrder.jumlah = number.toString()
            jumlah.setText(number.toString())
            detail.addItem(myOrder, "Kurang")
        })
        max.setOnClickListener(View.OnClickListener {
            view ->
            var number = myOrder.jumlah.toInt() + 1;
            myOrder.jumlah =number.toString()
            jumlah.setText(number.toString())
            detail.addItem(myOrder, "Tambah")
        })
        tNama.setText(myOrder.nama)
        tHarga.setText(myOrder.harga.toString())
        gambar.setImageResource(myOrder.gambar)
        return convertView
    }
}