package com.example.users.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.users.model.RepositoriesList
import com.example.users.model.RepositoryData


@Dao
interface ContactDao {

    @Query("SELECT * FROM repositories")
    fun getAllRecords():LiveData<RepositoriesList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(repositoriesList: RepositoryData)

    @Query("DELETE FROM repositories")
    fun deleteAllRecords()
}