package com.syoon.gitflow.repository

import androidx.lifecycle.LiveData
import com.syoon.gitflow.db.Word
import com.syoon.gitflow.db.WordDao

class WordRepository(private val wordDao: WordDao) {


    //database의 데이터를 가져오면 livedata가 이를 캐치함
    //data가 변경되면 메인 스레드 관찰자에게 알려줌
    val allWord: LiveData<List<Word>> = wordDao.getASCWord()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}