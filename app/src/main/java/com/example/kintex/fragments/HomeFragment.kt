package com.example.kintex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kintex.R
import com.example.kintex.databinding.FragmentHomeBinding
import com.example.kintex.databinding.FragmentMeetingBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.concurrent.fixedRateTimer

class HomeFragment() :Fragment() {
    //뷰바인딩 사용하는중
    private var mBinding : FragmentHomeBinding? = null
    //탭레이아웃이랑 뷰페이저 사용할 바인딩
    lateinit var fbinding :FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //이 프레그먼트페이지가 작동하도록 하는거
       val binding = FragmentHomeBinding.inflate(inflater,container,false)
        //뷰페이저할거
       fbinding = FragmentHomeBinding.inflate(inflater,container,false)

        //1.페이지 데이터 로드
        val list = listOf(AllFragment(),ExFragment(),MeetingFragment(),ShowFragment())
        //2.어답터 생성
        val pagerAdapter = FragmentPagerAdapter(list, this)
        //3.어담터와 뷰페이저 연결
        fbinding.viewPager.adapter = pagerAdapter
        //4.탭 메뉴의 개수만큼 제목을 목록으로 생성
        val titles = listOf("전체행사","전시회","회의","공연")
        //5. 탭 레이아웃과 뷰페이저 연결
        TabLayoutMediator(fbinding.tabLayout,fbinding.viewPager){tab,position->
            tab.text = titles.get(position)
        }.attach()

        //안에 있는 뷰페이저들 전송
        return fbinding.root
    }
    //어답터에서 this를 쓰기위해 안에도 밖에서 클래스 만든것 처럼 만들어줌 홈 프레그먼트라고 바뀐 부분도 있음
    class FragmentPagerAdapter(val fragmentList:List<Fragment>, fragmentActivity: HomeFragment) : FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList.get(position)
        }

    }

    override fun onDestroyView() {
        //해당 프레그먼트가 없어지면 없애는거
        mBinding =  null
        super.onDestroyView()
    }
}

class FragmentPagerAdapter(val fragmentList:List<Fragment>,fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

}