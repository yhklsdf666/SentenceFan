package com.yhklsdf.api

import com.yhklsdf.mvp.model.YiYanSentence
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("?c=a")
    fun getSentence() : Observable<YiYanSentence>
}