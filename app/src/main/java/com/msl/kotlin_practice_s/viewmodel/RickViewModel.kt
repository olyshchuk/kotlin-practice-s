package com.msl.kotlin_practice_s.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.msl.kotlin_practice_s.model.Character
import com.msl.kotlin_practice_s.utils.CharacterListDataSourceFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class RickViewModel(): ViewModel() {

    private var charactersPagedList: LiveData<PagedList<Character>>? = null
    private var executor: Executor? = null

    init {
        initPaging()
    }

    private fun initPaging() {
        val factory = CharacterListDataSourceFactory()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

        executor= Executors.newFixedThreadPool(5)

        charactersPagedList = LivePagedListBuilder(factory, config)
            .setFetchExecutor(executor!!)
            .build()

    }

    fun getRecyclerListDataObserver(): LiveData<PagedList<Character>>? {
        return charactersPagedList
    }
}