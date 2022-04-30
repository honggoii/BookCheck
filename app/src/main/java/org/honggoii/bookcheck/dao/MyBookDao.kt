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
    suspend fun getCode0(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '1'")
    suspend fun getCode1(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '2'")
    suspend fun getCode2(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '3'")
    suspend fun getCode3(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '4'")
    suspend fun getCode4(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '5'")
    suspend fun getCode5(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '6'")
    suspend fun getCode6(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '7'")
    suspend fun getCode7(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '8'")
    suspend fun getCode8(): Float

    @Query("SELECT COUNT(*) FROM my_book WHERE code == '9'")
    suspend fun getCode9(): Float
}
