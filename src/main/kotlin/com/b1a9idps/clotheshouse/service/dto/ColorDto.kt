package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.entity.Color

data class ColorDto (
        val id: Long?,
        val name: String?) {
    companion object {
        fun newInstance(color: Color) : ColorDto {
            return ColorDto(color.id, color.name)
        }
    }
}
