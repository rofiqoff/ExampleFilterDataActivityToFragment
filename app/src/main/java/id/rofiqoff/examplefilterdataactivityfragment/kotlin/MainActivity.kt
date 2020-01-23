package id.rofiqoff.examplefilterdataactivityfragment.kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import id.rofiqoff.examplefilterdataactivityfragment.PagerAdapter
import id.rofiqoff.examplefilterdataactivityfragment.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var searchDataListener: SearchDataListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val pageAdapter = PagerAdapter(supportFragmentManager)
        pageAdapter.addFragment(DataFragment())

        view_pager.adapter = pageAdapter

        edit_text_search?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (getSearchDataListener != null) {
                    getSearchDataListener?.onSearch(p0.toString())
                }
            }

        })
    }

    private val getSearchDataListener: SearchDataListener?
        get() = searchDataListener

    fun setSearchDataListener(searchDataListener: SearchDataListener?) {
        this.searchDataListener = searchDataListener
    }

    interface SearchDataListener {
        fun onSearch(dataToSearch: String)
    }

}
