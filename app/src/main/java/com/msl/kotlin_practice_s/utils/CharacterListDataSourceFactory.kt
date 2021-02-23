package com.msl.kotlin_practice_s.utils

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.msl.kotlin_practice_s.model.Character

class CharacterListDataSourceFactory(): DataSource.Factory<Int, Character>()  {

    private var mutableLiveData: MutableLiveData<CharacterListDataSource>? = null

    init {
        mutableLiveData = MutableLiveData<CharacterListDataSource>()
    }

    override fun create(): DataSource<Int, Character> {
        val listDataSource = CharacterListDataSource()
        mutableLiveData?.postValue(listDataSource);
        return listDataSource
    }
}