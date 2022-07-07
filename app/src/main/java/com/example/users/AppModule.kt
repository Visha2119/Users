package com.example.users

import android.content.Context
import com.example.users.DB.ContactDao
import com.example.users.DB.ContactDb
import com.example.users.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
class AppModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Context):ContactDb{
        return ContactDb.getInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(contactDb: ContactDb):ContactDao{
        return contactDb.getContactDao()
    }

    private val baseUrl = "https://randomuser.me/"
    private val client = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun getInstance(retrofit: Retrofit):Api{
        return retrofit.create(Api::class.java)
    }


    @Provides
    @Singleton
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .client(client)

            .build()


    }
}


