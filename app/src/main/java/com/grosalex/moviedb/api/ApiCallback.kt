package com.grosalex.moviedb.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


abstract class ApiCallback<T> : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.e(TAG, t.message)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            onSuccess(response.body())
        } else {
            onAnyError(response.message())
        }
    }

    abstract fun onSuccess(body: T?)
    abstract fun onAnyError(error: String)

    companion object {
        val TAG = ApiCallback::class.java.name
    }
}