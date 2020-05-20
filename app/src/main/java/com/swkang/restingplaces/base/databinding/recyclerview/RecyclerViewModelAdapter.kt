package com.example.mvvm.arch_reduxmvvm.base.databinding.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.swkang.restingplaces.base.databinding.ViewTypeProvider

/**
 * @param items 아이템 목록
 * @param viewTypeProvider 아이템(포지션)에 대응되는 각 뷰의 layout resource id provider 인스턴스.
 * @param onItemClickListener 아이템 뷰 대한 클릭 이벤트 콜백 리스너 인스턴스.
 */
class RecyclerViewModelAdapter<E>(
    private var items: ObservableList<E> = ObservableArrayList(),
    private val viewTypeProvider: ViewTypeProvider<E>? = null,
    private val onItemClickListener: ((E) -> Unit)? = null
) : RecyclerView.Adapter<DatabindingViewHolder>() {
    private val onListChangedListener = OnListChangedListener<ObservableList<E>>(this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatabindingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        val bindingViewHolder = DatabindingViewHolder(view)
        onItemClickListener?.let { listener ->
            bindingViewHolder.itemView.setOnClickListener {
                listener(getItem(bindingViewHolder.adapterPosition))
            }
        }
        return bindingViewHolder
    }

    override fun onBindViewHolder(holder: DatabindingViewHolder, position: Int) {
        val item = getItem(position)
        holder.binder?.let {
            //it.setVariable(BR.vm, item)
            //it.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        with(viewTypeProvider) {
            return if (this == null) 0
            else this(getItem(position), position)
        }
    }

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): E {
        return items.get(position)
            ?: throw IndexOutOfBoundsException("Elements of position [$position] has not founded.")
    }
}

class DatabindingViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    val binder: ViewDataBinding? = DataBindingUtil.bind(itemView)
}

private class OnListChangedListener<T : ObservableList<*>>(
    val adapter: RecyclerViewModelAdapter<*>
) : ObservableList.OnListChangedCallback<T>() {
    override fun onChanged(sender: T) {
        adapter.notifyDataSetChanged()
    }

    override fun onItemRangeRemoved(sender: T, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount)
    }

    override fun onItemRangeMoved(sender: T, fromPosition: Int, toPosition: Int, itemCount: Int) {
        adapter.notifyItemMoved(fromPosition, itemCount)
    }

    override fun onItemRangeInserted(sender: T, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeInserted(positionStart, itemCount)
    }

    override fun onItemRangeChanged(sender: T, positionStart: Int, itemCount: Int) {
        adapter.notifyItemChanged(positionStart, itemCount)
    }
}

