package id.rofiqoff.examplefilterdataactivityfragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_list_data.view.*

class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(data: Data) {
        itemView.text_data?.text = data.textData
    }
}