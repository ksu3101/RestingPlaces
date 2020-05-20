package com.swkang.restingplaces.base.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.swkang.model.domain.restingplaces.FavRestingPlacesViewModel
import com.swkang.restingplaces.R
import com.swkang.restingplaces.base.databinding.viewpager.ViewPagerModelAdapter

typealias ViewTypeProvider<T> = (item: T, position: Int) -> /* @LayoutRes */ Int

@BindingAdapter("onClick")
fun toOnClickListener(view: View, listener: () -> Unit) {
    return view.setOnClickListener { _ -> listener() }
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImageUrl(iv: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        iv.setImageDrawable(null)
    } else {
        Glide.with(iv.context)
            .load(url)
            .into(iv)
    }
}

@BindingAdapter("setupWithViewPager")
fun setUpWithViewPager(tabLayout: TabLayout, vp: ViewPager) {
    tabLayout.setupWithViewPager(vp)
}

@BindingAdapter(value = ["viewPagerItems", "viewProvider"])
fun <T : ViewModel> setUpViewPagerAdapter(
    vp: ViewPager,
    items: List<T>,
    viewTypeProvider: ViewTypeProvider<T>
) {
    vp.adapter = ViewPagerModelAdapter(items, viewTypeProvider)
}

/** RestingPlace 도메인에서만 사용 되는 ViewPager Adapter.
 **/
@BindingAdapter("vms")
fun setUpRestingPlaceViewPagerAdapter(vp: ViewPager, vms: List<ViewModel>) {
    setUpViewPagerAdapter(
        vp,
        vms
    ) { item, pos ->
        when (item) {
            is FavRestingPlacesViewModel -> R.layout.favrestingplaces_frag
            else -> R.layout.restingplaces_frag
        }
    }
}
