package com.example.kintex.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kintex.databinding.FragmentEventBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import android.util.Log
import com.example.kintex.RetrofitClient
import com.example.kintex.WeatherInterface
import com.example.kintex.models.WeatherResponse

class EventFragment : Fragment() {



    //뷰바인딩 사용하는중
    private var mBinding : FragmentEventBinding? = null
    //날씨정보를 위해 새로운 바인딩
    lateinit var fBinding : FragmentEventBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentEventBinding.inflate(inflater,container,false)
        mBinding = binding
        fBinding = binding
        binding.activityMainBtn.setOnClickListener {
            val lat = binding.activityMainEtLat.text.toString()
            val lon = binding.activityMainEtLon.text.toString()
            val key = "88d718baed14f395b7adf6a4eaeeb273"
            getWeatherData(lat,lon,key)
        }
        return fBinding.root
    }

    //API호출을 위한 메서드 구성
    private fun getWeatherData(l1 : String, l2 : String, key : String){
        val weatherInterface = RetrofitClient.sRetrofit.create(WeatherInterface::class.java)
        weatherInterface.getWeater(l1,l2,key).enqueue(object : Callback<WeatherResponse>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful){
                    val result = response.body() as WeatherResponse
                    fBinding.activityMainTv.text = result.main.temp.toString() + "도"
                } else{
                    Log.d("MainActivity","getWeatherData - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("MainActivity",t.message ?:"통신오류")
            }

        })
    }





    override fun onDestroyView() {
        mBinding =  null
        super.onDestroyView()
    }
}