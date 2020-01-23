package id.rofiqoff.examplefilterdataactivityfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(manager: FragmentManager) :
    FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mFragmentList = arrayListOf<Fragment>()
    private val mFragmentTitleList = arrayListOf<String>()

    override fun getItem(position: Int): Fragment = mFragmentList[position]

    override fun getCount(): Int = mFragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = mFragmentTitleList[position]

    fun addFragment(fragment: Fragment, title: String = "") {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

}