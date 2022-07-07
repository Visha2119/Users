package com.example.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contact.ItemAdapter
import com.example.users.model.RepositoriesList
import com.example.users.viewmodel.ContactViewModel
import com.example.users.viewmodel.ContactViewModelFactory
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  lateinit var itemAdapter: ItemAdapter
    private lateinit var recyclerView:RecyclerView
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initApi()
    }

    private fun initApi(){
        viewModel=ViewModelProvider(this).get(ContactViewModel::class.java)

        viewModel.getAllRepositoryList().observe(this, Observer<RepositoriesList>{
            initViewModel(it)
        })
        viewModel.makeApiCall()
    }
    private fun initViewModel(datas:RepositoriesList){
            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            itemAdapter=ItemAdapter(datas,this)
            recyclerView.adapter=itemAdapter

    }




//    private fun viewModelFun(){
//        val  view=ViewModelProvider(this).get(ContactViewModel::class.java)
//        view.getAllRepositoryList().observe(this,Observer<RepositoriesList>{
//            initViewModel(it)
//        })
//        view.makeApiCall()
//    }


}