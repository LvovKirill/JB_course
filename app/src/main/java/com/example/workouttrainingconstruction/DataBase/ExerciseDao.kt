package com.example.workouttrainingconstruction.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExerciseDao {
    @Insert
    fun insertAll(vararg exercises: Exercise?)

    @Insert
    fun insertExercise(exercise: Exercise?)

    @Delete
    fun delete(exercise: Exercise?)

    @Query("DELETE FROM exercise_table")
    fun deleteAll()

    @Query("DELETE FROM exercise_table WHERE id = :id")
    fun deleteByID(id: Int)

    @get:Query("SELECT*FROM exercise_table")
    val allExercise: MutableList<Exercise>

    @Query("SELECT*FROM exercise_table WHERE id = :id")
    fun getExerciseByID(id: Int?): Exercise?

    @Query("SELECT name FROM exercise_table WHERE id = :id")
    fun getNameByID(id: Int?): String?

    @get:Query("SELECT * FROM exercise_table")
    val allExerciseLiveData: LiveData<List<Exercise?>?>?
}