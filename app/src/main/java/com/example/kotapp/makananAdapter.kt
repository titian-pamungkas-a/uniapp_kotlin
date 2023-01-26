package com.example.kotapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class makananAdapter : ArrayAdapter<Lauk> {

    lateinit var inter:listInterface

    constructor(context: Context, resource: Int, listnama:ArrayList<Lauk>, inter: listInterface) : super(context, resource, listnama){
        this.inter = inter
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var mylauk: Lauk = getItem(position)!!
        var convertView = convertView
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.makananlayout, parent, false)
        }
        val tNama:TextView = convertView!!.findViewById(R.id.tnama)
        val tDes:TextView = convertView.findViewById(R.id.tdeskripsi)
        val tGambar:ImageView = convertView.findViewById(R.id.tgambar)
        tNama.setText(mylauk.namaLauk)
        tDes.setText(mylauk.keterangan)
        tGambar.setImageResource(mylauk.gambar)
        convertView.setOnClickListener(View.OnClickListener {
            view ->
            inter.tampilkanDetail(mylauk)
        })
        return convertView
    }
}