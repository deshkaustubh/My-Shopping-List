package com.example.myshoppinglistapp

import android.health.connect.datatypes.ExerciseRoute.Location
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch
import java.lang.Exception

class LocationViewModel: ViewModel(){
    private val _location = mutableStateOf<LocationData?>(null)
    val location : State<LocationData?> = _location

    private val _address  = mutableStateOf(listOf<GeocodingResult>())
    val address: State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }

    fun fetchAddress(latLng: String){
        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latLng,
                    apiKey = "AlzaSynTRUjdoyiVspGwgHkwLtoBCJ7IknfioXZ"// Api key is of gomaps
                )
                _address.value = result.results
            }
        }catch (e:Exception){
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }
}