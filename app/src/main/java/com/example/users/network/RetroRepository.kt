package com.example.users.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.users.DB.ContactDao
import com.example.users.model.RepositoriesList
import com.example.users.model.RepositoryData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val  retroserviceInterface:Api,
                                          private  val contactDao: ContactDao) {
    fun getAllRecords(): LiveData<RepositoriesList> {
         return  contactDao.getAllRecords()
    }

    fun insertRecords(repositoryData: RepositoryData){
        contactDao.insertRecords(repositoryData)
    }

    fun makeApiCall(query:String?){
        val call:Call<RepositoriesList> = retroserviceInterface.getResults(query!!)
        call?.enqueue(object :Callback<RepositoriesList>{
            override fun onResponse(
                call: Call<RepositoriesList>,
                response: Response<RepositoriesList>
            ) {
                if (response.isSuccessful){
                    contactDao.deleteAllRecords()
                    response.body()?.results?.forEach{
                        insertRecords(it)
                    }
                }
            }

            override fun onFailure(call: Call<RepositoriesList>, t: Throwable) {
                Log.d("OnFailure method - ", t.message.toString())
            }

        })
    }
}