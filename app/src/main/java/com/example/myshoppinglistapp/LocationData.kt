package com.example.myshoppinglistapp

data class LocationData(
    val latitude : Double,
    val longitude : Double
) {
    companion object {
        val longitude: String
        val latitude: String
    }
}

data class GeocodingResponse(
    val results: List<GeocodingResult>,
    val status: String
)

data class GeocodingResult(
    val formatted_address : String
)