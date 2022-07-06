package com.syoon.gitflow.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    //저장된 단어 오름차순으로 가져오기
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getASCWord() : LiveData<List<Word>> //데이터 변경될 때마다 반응할 수 있도록 관찰

    //단어 추가
    //IGNORE : 동일한 단어 무시
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    //전체 단어 지우기
    @Delete
    suspend fun deleteAll(word: Word)
}