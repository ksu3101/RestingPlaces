package com.swkang.model.domain.restingplaces

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swkang.model.base.BaseViewModel
import com.swkang.model.base.helper.MessageHelper
import com.swkang.model.base.subscribeWith
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import com.swkang.model.domain.restingplaces.rvvms.RestingPlaceItemViewModel
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/17/2020
 */
open class RestingPlacesViewModel @Inject constructor(
//    val repo: RestingPlaceRepository,
//    val messageHelper: MessageHelper
) : BaseViewModel() {

    val restingPaceItems = ObservableArrayList<ViewModel>()

    private val _hasNextPage = MutableLiveData(false)
    val hasNextPage: LiveData<Boolean>
        get() = _hasNextPage

    private var totalCount = 0L
    private var currentPage = 0
    private var isLoadNextPage = false

    init {
        retrieveRestingPlace(currentPage)
    }

    private fun checkLoadNextPage(): Boolean {
        return !isLoadNextPage && restingPaceItems.size < totalCount
    }

    private fun retrieveRestingPlace(page: Int = 0) {
        if (!checkLoadNextPage()) return
        /*
        isLoadNextPage = true
        repo.retrieveRestingPlace(page)
            .toObservable()
            .flatMapIterable {
                totalCount = it.totalCount
                it.product
            }
            .map { RestingPlaceItemViewModel(it, repo) }
            .toList()
            .subscribeWith(this,
                {
                    restingPaceItems.addAll(it)
                    isLoadNextPage = false
                    if (checkLoadNextPage()) currentPage++
                },
                {
                    // todo : re-try alert dialog
                    isLoadNextPage = false
                })
         */
    }

}