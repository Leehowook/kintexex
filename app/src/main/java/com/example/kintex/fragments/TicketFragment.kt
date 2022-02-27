package com.example.kintex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kintex.databinding.FragmentTicketBinding

class TicketFragment : Fragment() {
    //뷰바인딩 사용하는중중
    private var mBinding : FragmentTicketBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTicketBinding.inflate(inflater,container,false)
        mBinding = binding
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding =  null
        super.onDestroyView()
    }
}