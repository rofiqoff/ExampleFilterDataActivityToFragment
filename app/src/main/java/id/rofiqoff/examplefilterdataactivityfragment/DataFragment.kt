package id.rofiqoff.examplefilterdataactivityfragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_data.*

/**
 * A simple [Fragment] subclass.
 */
class DataFragment : Fragment() {

    private var adapter: Adapter<Data, DataViewHolder>? = null

    val datas: ArrayList<Data>
        get() = arrayListOf<Data>().apply {
            add(Data("Real Madrid"))
            add(Data("Barcelona"))
            add(Data("Manchester United"))
            add(Data("Manchester City"))
            add(Data("Liverpool"))
            add(Data("Juventus"))
            add(Data("Chelsea"))
            add(Data("Atletico Madrid"))
            add(Data("Paris Saint German"))
            add(Data("Ac Milan"))
            add(Data("Inter Milan"))
            add(Data("AS Roma"))
        }

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
