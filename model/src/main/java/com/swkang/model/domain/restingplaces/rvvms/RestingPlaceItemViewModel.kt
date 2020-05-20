package com.swkang.model.domain.restingplaces.rvvms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swkang.model.base.BaseViewModel
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import com.swkang.model.domain.restingplaces.repository.dto.RestingPlace

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class RestingPlaceItemViewModel(
    restingPlaceItem: RestingPlace,
    repo: RestingPlaceRepository
) : BaseViewModel() {

    private val _name = MutableLiveData(restingPlaceItem.name)
    val name: LiveData<String>
        get() = _name

    private val _thumbnail = MutableLiveData(restingPlaceItem.thumbnail)
    val thumbnail: LiveData<String>
        get() = _thumbnail

    private val _rate = MutableLiveData(restingPlaceItem.rate)
    val rate: LiveData<Double>
        get() = _rate

    private val _subject = MutableLiveData(restingPlaceItem.description.subject)
    val subject: LiveData<String>
        get() = _subject

    private val _price = MutableLiveData(restingPlaceItem.description.price)
    val price: LiveData<Long>
        get() = _price

    private val _isFavorite = MutableLiveData(false)
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    val onToggleFavoriteClicked = {
        repo.toggleFavoriteRestingPlace(restingPlaceItem)
    }

}