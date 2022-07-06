package com.syoon.gitflow.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey
    //열 이름 지정 @ColoumnInfo(name="필드 이름")
    @ColumnInfo(name= "word") val word: String
)
