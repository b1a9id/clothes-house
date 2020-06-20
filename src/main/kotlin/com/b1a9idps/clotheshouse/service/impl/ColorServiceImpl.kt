package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Color
import com.b1a9idps.clotheshouse.repository.ColorRepository
import com.b1a9idps.clotheshouse.service.ColorService
import com.b1a9idps.clotheshouse.service.dto.ColorDto
import org.springframework.stereotype.Service

@Service
class ColorServiceImpl(val colorRepository: ColorRepository) : ColorService {

    private val colorDtoTransformer : (Color) -> ColorDto =
            { color -> ColorDto.newInstance(color) }

    override fun list(): List<ColorDto> {
        return colorRepository.findAll().mapNotNull(colorDtoTransformer)
    }

    override fun get(id: Long): ColorDto {
        return colorRepository.findById(id)
                .map(colorDtoTransformer)
                .orElse(null)
    }
}
