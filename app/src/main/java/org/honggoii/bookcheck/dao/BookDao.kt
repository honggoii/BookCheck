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
}
