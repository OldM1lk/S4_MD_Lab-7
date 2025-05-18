package com.example.lab_7.data.local

import com.google.android.gms.maps.model.LatLng

data class Route(
    val points: List<LatLng> = emptyList(),
    val polyline: String = ""
)