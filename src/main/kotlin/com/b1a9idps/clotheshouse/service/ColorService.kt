package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.ColorDto
import java.util.*

interface ColorService {
    fun list() : List<ColorDto>
    fun get(id : Long?) : Optional<ColorDto>
}
