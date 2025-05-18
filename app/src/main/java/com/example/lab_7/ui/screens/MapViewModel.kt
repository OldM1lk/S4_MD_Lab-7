package com.example.lab_7.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lab_7.data.Points
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState

class MapViewModel : ViewModel() {
    private val predefinedLocation = LatLng(55.354993, 86.085805)

    private val _points = mutableStateOf(Points())
    val points: State<Points> = _points

    fun moveToPredefinedLocation(cameraPositionState: CameraPositionState) {
        cameraPositionState.move(CameraUpdateFactory.newLatLngZoom(predefinedLocation, 15f))
    }

    fun addPoint(point: LatLng) {
        val current = _points.value
        _points.value = when {
            current.start == null -> current.copy(start = point)
            current.end == null -> current.copy(end = point)
            else -> Points()
        }
    }
}