package com.example.khotijatuzzahroproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var InputNis : EditText
    private lateinit var InputNama : EditText
    private lateinit var jklaki : RadioButton
    private lateinit var jkpr : RadioButton
    private lateinit var tambahData : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InputNis = findViewById(R.id.txtInputNis)
        InputNama = findViewById(R.id.txtInputNama)
        jklaki = findViewById(R.id.rbLaki)
        jkpr = findViewById(R.id.rbPr)
        tambahData = findViewById(R.id.btntambahDt)
        recyclerView = findViewById(R.id.rvLisData)
        //membuat variabel kosong tipe array mutablelist untuk simpan data array
        //data array di simpan di data class siswaData
        val data = mutableListOf<siswaData>()
        viewManager= LinearLayoutManager(this)
        recyclerAdapter= siswaAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
        //setOnclikListener untuk tombol tambah data
        tambahData.setOnClickListener {
            //1. membuat variabel penyimpan data
            val nis = InputNis.text.toString()//edittext.text => String
            val nama = InputNama.text.toString()
            var jk = ""
            if (jklaki.isChecked){
                jk = "Laki-Laki"
            }else {
                jk = "Perempuan"
            }
            // simpan data ke array mutableList
            val dataSiswa = siswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }
}