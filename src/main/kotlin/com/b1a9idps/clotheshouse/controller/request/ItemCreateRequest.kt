package com.b1a9idps.clotheshouse.controller.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ItemCreateRequest(
        @field:NotEmpty
        val imageUrl : String?,
        @field:NotNull
        val brandId : Long?,
        @field:NotNull
        val genreId : Long?,
        @field:NotNull
        val colorId: Long?)
