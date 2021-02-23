package com.msl.kotlin_practice_s.utils

import androidx.paging.PageKeyedDataSource
import com.msl.kotlin_practice_s.model.Character
import com.msl.kotlin_practice_s.model.RickListModel
import com.msl.kotlin_practice_s.network.RetroInstance
import com.msl.kotlin_practice_s.network.RetroService
import retrofit2.Call
import retrofit2.Response

class CharacterListDataSource() : PageKeyedDataSource<Int, Character>()  {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Character>) {
        val retroInstance = RetroInstance.getInstance().create(RetroService::class.java)
        val call = retroInstance.getData(1)
        call.enqueue(object : retrofit2.Callback<RickListModel>{
            override fun onResponse(call: Call<RickListModel>, response: Response<RickListModel>) {
                if(response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, null, 2)
                }
            }

            override fun onFailure(call: Call<RickListModel>, t: Throwable) {
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        val retroInstance = RetroInstance.getInstance().create(RetroService::class.java)
        val call = retroInstance.getData(params.key)
        call.enqueue(object : retrofit2.Callback<RickListModel>{
            override fun onResponse(call: Call<RickListModel>, response: Response<RickListModel>) {
                if(response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, params.key + 1)
                }
            }

            override fun onFailure(call: Call<RickListModel>, t: Throwable) {
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {

    }
}
