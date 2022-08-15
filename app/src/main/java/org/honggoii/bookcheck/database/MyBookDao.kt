package org.honggoii.bookcheck.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyBookDao {

    @Query("SELECT * FROM my_book")
    fun getAll(): Flow<List<MyBook>>

    @Query("SELECT COUNT(*), code FROM my_book GROUP BY code")
    fun getCode(): Flow<List<Code>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(myBook: MyBook)
}
