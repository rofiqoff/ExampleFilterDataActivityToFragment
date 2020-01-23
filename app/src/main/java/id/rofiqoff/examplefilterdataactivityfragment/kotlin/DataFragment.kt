package id.rofiqoff.examplefilterdataactivityfragment.kotlin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.rofiqoff.examplefilterdataactivityfragment.*
import kotlinx.android.synthetic.main.fragment_data.*

/**
 * A simple [Fragment] subclass.
 */
class DataFragment : Fragment() {

    private var adapter: Adapter<Data, DataViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        initAdapter()

        list_data?.adapter = adapter

        adapter?.updateData(datas)

        (activity as MainActivity).setSearchDataListener(object :
            MainActivity.SearchDataListener {
            override fun onSearch(dataToSearch: String) {
                search(dataToSearch)
            }
        })
    }

    private fun initAdapter() {
        adapter = object : Adapter<Data, DataViewHolder>(
            R.layout.row_list_data, DataViewHolder::class.java, arrayListOf()
        ) {
            override fun bindView(holder: DataViewHolder?, model: Data, position: Int) {
                holder?.onBind(model)
            }
        }
    }

    fun search(dataToSearch: String) {
        val dataFilter = datas.filter {
            it.textData.contains(dataToSearch, true)
        }

        adapter?.apply {
            if (dataToSearch == "") {
                updateData(datas)
            } else {
                updateData(dataFilter as MutableList<Data>)
            }
        }
    }

}
