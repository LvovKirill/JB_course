package com.example.workouttrainingconstruction.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TrainingDao {
    @Insert
    fun insertAll(vararg trainings: Training?)

    @Insert
    fun insertTraining(training: Training?)

    @Delete
    fun delete(training: Training?)

    @Query("DELETE FROM training_table")
    fun deleteAll()

    @Query("DELETE FROM training_table WHERE id = :id")
    fun deleteById(id: Int)

    @get:Query("SELECT*FROM training_table")
    val allTraining: MutableList<Training>

    @Query("SELECT*FROM training_table WHERE id = :id")
    fun getTrainingByID(id: Int): Training?

    @get:Query("SELECT * FROM training_table")
    val allTrainingLiveData: LiveData<List<Training?>?>?
}