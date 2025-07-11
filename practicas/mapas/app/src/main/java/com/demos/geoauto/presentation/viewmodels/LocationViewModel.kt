package com.demos.geoauto.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng


class LocationViewModel : ViewModel() {

    private val _ubicacionActual = MutableLiveData<LatLng>()
    val ubicacionActual: LiveData<LatLng> = _ubicacionActual



}