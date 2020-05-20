package com.swkang.restingplaces.base.databinding.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.PagerAdapter
import com.swkang.restingplaces.base.databinding.ViewTypeProvider

/**
 * @author kangsungwoo
 * @since 5/17/2020
 */

class ViewPagerModelAdapter<T : ViewModel>(
    private val items: List<T>,
    private val viewTypeProvider: ViewTypeProvider<T>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = getItem(position)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            viewTypeProvider(item, position),
            container,
            false
        )
        container.addView(binding.root)
        //binding.setVariable(BR.vm, item)
        binding.executePendingBindings()
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = items.size

    fun getItem(pos: Int):T = items.get(pos)

}