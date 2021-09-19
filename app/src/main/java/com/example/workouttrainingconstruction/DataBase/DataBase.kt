package com.example.workouttrainingconstruction.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.workouttrainingconstruction.DataBase.Exercise
import com.example.workouttrainingconstruction.DataBase.Training
import java.util.concurrent.Executors

@Database(entities = [Training::class, Exercise::class], version = 1, exportSchema = true)
abstract class DataBase : RoomDatabase() {
    abstract fun trainingDao(): TrainingDao
    abstract fun exerciseDao(): ExerciseDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null
        private const val NUMBER_OF_THREADS = 4
        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
        fun getDatabase(context: Context?): DataBase? {
            if (INSTANCE == null) {
                synchronized(DataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context!!.applicationContext,
                            DataBase::class.java, "room_database"
                        )
                            .allowMainThreadQueries()
                            .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        private val sRoomDatabaseCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                databaseWriteExecutor.execute {
                    val dao = INSTANCE!!.trainingDao()
                    dao.deleteAll()
                    val training = Training("Training 1")
                    dao.insertTraining(training)
                    val training2 = Training("Training 2")
                    dao.insertTraining(training2)
                    val training3 = Training("Training 3")
                    dao.insertTraining(training3)
                    val training4 = Training("Training 4")
                    dao.insertTraining(training4)
                    val training5 = Training("Training 5")
                    dao.insertTraining(training5)
                    val training6 = Training("Training 6")
                    dao.insertTraining(training6)
                    val training7 = Training("Training 7")
                    dao.insertTraining(training7)
                    val training8 = Training("Training 8")
                    dao.insertTraining(training8)
                    val training9 = Training("Training 9")
                    dao.insertTraining(training9)
                    val training10 = Training("Training 10")
                    dao.insertTraining(training10)
                }
                databaseWriteExecutor.execute {
                    val dao = INSTANCE!!.exerciseDao()
                    dao.deleteAll()
                    val exercise = Exercise("Exercise 1")
                    dao.insertExercise(exercise)
                    val exercise2 = Exercise("Exercise 2")
                    dao.insertExercise(exercise2)
                    val exercise3 = Exercise("Exercise 3")
                    dao.insertExercise(exercise3)
                    val exercise4 = Exercise("Exercise 4")
                    dao.insertExercise(exercise4)
                    val exercise5 = Exercise("Exercise 5")
                    dao.insertExercise(exercise5)
                    val exercise6 = Exercise("Exercise 6")
                    dao.insertExercise(exercise6)
                    val exercise7 = Exercise("Exercise 7")
                    dao.insertExercise(exercise7)
                    val exercise8 = Exercise("Exercise 8")
                    dao.insertExercise(exercise8)
                    val exercise9 = Exercise("Exercise 9")
                    dao.insertExercise(exercise9)
                    val exercise10 = Exercise("Exercise 10")
                    dao.insertExercise(exercise10)
                }
            }
        }
    }
}