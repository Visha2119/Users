package com.example.users

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class User: AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.user)

            val name=findViewById<TextView>(R.id.nameDetail)
            val gender =findViewById<TextView>(R.id.genderDetail)
            val country=findViewById<TextView>(R.id.countryDetail)
            val phone=findViewById<TextView>(R.id.phoneDetail)
            val img=findViewById<ImageView>(R.id.img)

            val extract = intent.extras

            val namevalue = extract?.getString("name")
            val gendervalue = extract?.getString("gender")
            val countryvalue=extract?.getString("country")
            var phoneValue=extract?.getString("phone")
            val imagevalue = extract?.getString("img")


            Glide.with(this.applicationContext)
                .load(imagevalue)
                .into(img)

            name.text = namevalue.toString()
            gender.text = gendervalue.toString()
            country.text=countryvalue.toString()
            phone.text=phoneValue.toString()



            //Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        }
    }
