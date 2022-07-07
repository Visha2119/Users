package com.example.contact

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.users.R
import com.example.users.User
import com.example.users.model.RepositoriesList


class ItemAdapter(private var itemList: RepositoriesList, private var context: Context): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val cardView: CardView = itemView.findViewById(R.id.cv_user)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.each_item), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemsViewModel = itemList.results.get(position)


        //  Log.d("Recycler view ", itemList[position].toString())
        //    Log.d("Size of List", itemsViewModel.toString())

        holder.textView.text = itemsViewModel.name.first
        Glide.with(holder.itemView.getContext())
            .load(itemsViewModel.picture.large)
            .into(holder.imageView)

        //holder.imageView.setImageResource(itemList[position])

        holder.cardView.setOnClickListener {
            val intend= Intent(context, User::class.java )
            intend.putExtra("name", itemsViewModel.name.title+" "+ itemsViewModel.name.first+" "+itemsViewModel.name.last)
            intend.putExtra("gender", itemsViewModel.gender)
            intend.putExtra("country",itemsViewModel.location.country)
            intend.putExtra("img",itemsViewModel.picture.large)
            intend.putExtra("phone",itemsViewModel.Phone)
            context.startActivity(intend)
//

        }
    }

    override fun getItemCount(): Int {
        return itemList.results.size
    }
}


