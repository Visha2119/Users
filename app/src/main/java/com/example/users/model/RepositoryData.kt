package com.example.users.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Entity(tableName = "repositories")
data class RepositoryData(
    @PrimaryKey(autoGenerate = true)
    val Phone:Long,

    @ColumnInfo(name = "gender")
    val gender:String,

    @ColumnInfo(name = "name")
    val name:Name,

    @ColumnInfo(name="picture")
    val picture:Picture,

    @ColumnInfo(name = "location")
    val location:Location
)

data class Name(
    val title:String,
    val first: String,
    val last:String
)

data class Location(

    val country:String,
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)



class  TypeConverterData {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String): RepositoriesList? {

        val listType: Type = object : TypeToken<RepositoryData?>() {}.type
        return gson.fromJson<RepositoriesList?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someobject: RepositoryData?): String? {
        return gson.toJson(someobject)
    }
}