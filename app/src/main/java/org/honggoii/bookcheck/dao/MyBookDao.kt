package org.honggoii.bookcheck.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.honggoii.bookcheck.entity.MyBook

@Dao
interface MyBookDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myBook: MyBook?)

    @Update
    suspend fun update(myBook: MyBook)

    @Delete
    suspend fun delete(myBook: MyBook)

    @Query("SELECT * FROM my_book")
    fun getAll(): LiveData<List<MyBook>>

    @Query("DELETE FROM my_book")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '0'")
    fun getCode0(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '1'")
    fun getCode1(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '2'")
    fun getCode2(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '3'")
    fun getCode3(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '4'")
    fun getCode4(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '5'")
    fun getCode5(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '6'")
    fun getCode6(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '7'")
    fun getCode7(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '8'")
    fun getCode8(): LiveData<Float>

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '9'")
    fun getCode9(): LiveData<Float>
}
