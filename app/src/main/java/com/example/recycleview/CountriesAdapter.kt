package com.example.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CountriesAdapter(
    var countryList: ArrayList<String>,
    var detailList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context
): RecyclerView.Adapter<CountriesAdapter.countryViewHolder>() {//derive countriesAdapterClass from recyclerView Adapter class

    class  countryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){//it represent the card design
        var textViewCountryName:TextView=itemView.findViewById(R.id.textViewCountry)
        var textViewDetail:TextView=itemView.findViewById(R.id.textView2)
        var imageView:CircleImageView=itemView.findViewById(R.id.imageView)
        var  cardView:CardView=itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryViewHolder {//in this method we define the card design we made.define which design despaired on recycler view
val view:View=LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent,false)
        return countryViewHolder(view)
    }

    override fun getItemCount(): Int {//the count that should displayed on recyclerview

return  countryList.size
    }

    override fun onBindViewHolder(holder: countryViewHolder, position: Int) {  //it will define what should do when the design will connected to the recyclerview
holder.textViewCountryName.text=countryList.get(position)
        holder.textViewDetail.text=detailList.get(position)
        holder.imageView.setImageResource(imageList.get(position))
        holder.cardView.setOnClickListener {
            Toast.makeText(context,"${countryList.get(position)} is selected",Toast.LENGTH_SHORT).show()
        }

    }

}