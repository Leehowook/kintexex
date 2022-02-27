package com.example.kintex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kintex.databinding.FragmentTrafficBinding

class TrafficFragment : Fragment() {
    //뷰바인딩 사용하는중
    private var mBinding : FragmentTrafficBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTrafficBinding.inflate(inflater,container,false)
        mBinding = binding
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding =  null
        super.onDestroyView()
    }
}