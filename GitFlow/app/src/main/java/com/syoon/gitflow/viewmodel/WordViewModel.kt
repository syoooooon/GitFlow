package com.syoon.gitflow.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.syoon.gitflow.db.AppDataBase
import com.syoon.gitflow.db.Word
import com.syoon.gitflow.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    val allWord: LiveData<List<Word>>

    init {
        val wordDao = AppDataBase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        allWord = repository.allWord
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}