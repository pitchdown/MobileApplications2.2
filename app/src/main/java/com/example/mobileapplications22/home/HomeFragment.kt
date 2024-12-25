package com.example.mobileapplications22.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.mobileapplications22.R
import com.example.mobileapplications22.adapters.ViewPagerAdapter

class HomeFragment : Fragment() {

    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString("title")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.let {
            val fragmentList = listOf(
                HomeFragment.newInstance("Page 1"),
                HomeFragment.newInstance("Page 2"),
                HomeFragment.newInstance("Page 3")
            )
            val adapter = ViewPagerAdapter(requireActivity() as FragmentActivity, fragmentList)
            it.adapter = adapter
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String = "Home Page"): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }
    }
}

