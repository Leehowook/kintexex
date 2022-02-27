package com.example.kintex.models


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    var lat: Int,
    @SerializedName("lon")
    var lon: Int
)