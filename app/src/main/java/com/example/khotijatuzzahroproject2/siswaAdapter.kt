package com.example.khotijatuzzahroproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class siswaAdapter (private val dataSet:MutableList<siswaData>):
        RecyclerView.Adapter<siswaAdapter.siswaHolder>(){


    class siswaHolder(view: View):RecyclerView.ViewHolder(view) {
        val nis = view.findViewById<TextView>(R.id.txtDataNis)
        val nama =view.findViewById<TextView>(R.id.txtDataNama)
        val jekel = view.findViewById<TextView>(R.id.txtDataJk)
        val btnEdit= view.findViewById<TextView>(R.id.btnEdit)
        val btnHapus= view.findViewById<TextView>(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): siswaHolder {
       val view= LayoutInflater.from(parent.context).inflate(
           R.layout.activity_siswa_adapter,parent,false
       )
        return siswaHolder(view)
    }

    override fun onBindViewHolder(holder: siswaHolder, position: Int) {
        holder.nis.text = dataSet[position].nis
        holder.nama.text = dataSet[position].nama
        holder.jekel.text = dataSet[position].jekel
        holder.btnHapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeChanged(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}