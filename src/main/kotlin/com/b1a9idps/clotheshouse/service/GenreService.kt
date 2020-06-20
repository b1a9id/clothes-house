package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.GenreDto
import java.util.*

interface GenreService {
    fun list() : List<GenreDto>
    fun get(id : Long?) : Optional<GenreDto>
}
