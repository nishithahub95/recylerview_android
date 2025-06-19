package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
   lateinit var  recyclerView:RecyclerView
   var countryList=ArrayList<String>()
    var detailList=ArrayList<String>()
    var imageList=ArrayList<Int>()

    lateinit var adapter: CountriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        countryList.add("India")
        countryList.add("UK")
        countryList.add("Us")

        detailList.add("This is an Indian flag")
        detailList.add("This is the UK flg")
        detailList.add("This is the US flag")

        imageList.add(R.drawable.india)
        imageList.add(R.drawable.uk)
        imageList.add(R.drawable.us)
        adapter=CountriesAdapter(countryList,detailList,imageList,this@MainActivity)
        recyclerView.adapter=adapter



    }
}