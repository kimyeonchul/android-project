package com.example.software

import androidx.room.*

@Dao
interface ProfileDao {
    @Insert
    fun insert(profile: Profile)

    @Delete
    fun delete(profile:Profile)

    @Update
    fun update(profile: Profile)

    @Query("SELECT * FROM profile") //가져와라 모든 값을 profile테이블에서
    fun getAll(): Profile

}