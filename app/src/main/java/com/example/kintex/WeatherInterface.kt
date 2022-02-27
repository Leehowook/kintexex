package com.example.kintex

import com.example.kintex.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {

    @GET("weather")
    fun getWeater(@Query("lat") lat:String,
                  @Query("lon") lon:String,
                  @Query("appid") appid:String
    ) : Call<WeatherResponse>
}