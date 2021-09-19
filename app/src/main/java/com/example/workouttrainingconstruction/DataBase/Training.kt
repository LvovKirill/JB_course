package com.example.workouttrainingconstruction.DataBase

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "training_table")
class Training {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var name: String

    @Ignore
    constructor(name: String) {
        this.name = name
    }

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }
}