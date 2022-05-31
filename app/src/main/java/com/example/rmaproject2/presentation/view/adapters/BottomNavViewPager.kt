package com.example.rmaproject2.presentation.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rmaproject2.presentation.view.fragments.NotesFragment
import com.example.rmaproject2.presentation.view.fragments.ScheduleFragment
import com.example.rmaproject2.presentation.view.fragments.StatisticsFragment

class BottomNavViewPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object {
        const val ITEM_COUNT = 3
        const val FRAG_1_SCHEDULE = 0
        const val FRAG_2_NOTES = 1
        const val FRAG_3_STATS = 2
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getItem(position: Int): Fragment {

        val fragment: Fragment = when (position) {
            FRAG_1_SCHEDULE -> ScheduleFragment()
            FRAG_2_NOTES -> NotesFragment()
            FRAG_3_STATS -> StatisticsFragment()
            else -> throw IllegalStateException("Unexpected value: $position")
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            FRAG_1_SCHEDULE -> "Schedule"
            FRAG_2_NOTES -> "Notes"
            FRAG_3_STATS -> "Statistics"
            else -> "error"
        }
    }
}