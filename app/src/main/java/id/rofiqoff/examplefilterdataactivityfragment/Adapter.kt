package id.rofiqoff.examplefilterdataactivityfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException

abstract class Adapter<DataType, ViewHolder : RecyclerView.ViewHolder?>(
    private var mLayout: Int,
    private var mViewHolderClass: Class<ViewHolder>,
    data: MutableList<DataType>
) : RecyclerView.Adapter<ViewHolder>() {

    private var mData: MutableList<DataType>

    init {
        this.mData = data
    }

    fun addData(data: DataType) {
        mData.add(data)
        notifyItemInserted(itemCount - 1)
    }

    fun addListData(list: List<DataType>?) {
        mData.addAll(list!!)
        notifyDataSetChanged()
    }

    fun insertData(position: Int, data: DataType) {
        mData.add(position, data)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, mData.size)
    }

    fun removeData(position: Int) {
        mData.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mData.size)
    }

    fun updateData(list: MutableList<DataType>) {
        mData = list
        notifyDataSetChanged()
    }

    fun getmData(): List<DataType> {
        return mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(mLayout, parent, false) as ViewGroup
        return try {
            val constructor: Constructor<ViewHolder> =
                mViewHolderClass.getConstructor(
                    View::class.java
                )
            constructor.newInstance(view)
        } catch (e: NoSuchMethodException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        } catch (e: InstantiationException) {
            throw RuntimeException(e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException(e)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position)
        bindView(holder, model, position)
    }

    protected abstract fun bindView(
        holder: ViewHolder?,
        model: DataType,
        position: Int
    )

    private fun getItem(position: Int): DataType {
        return mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}