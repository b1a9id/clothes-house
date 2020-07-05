package com.b1a9idps.clotheshouse.controller.request

data class ItemCreateRequest(
        val imageUrl : String,
        val brandId : Long,
        val genreId : Long,
        val colorId: Long)
