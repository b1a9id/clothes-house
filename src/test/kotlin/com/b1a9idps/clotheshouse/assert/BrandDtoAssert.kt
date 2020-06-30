package com.b1a9idps.clotheshouse.assert

import com.b1a9idps.clotheshouse.service.dto.BrandDto
import org.assertj.core.api.AbstractAssert
import java.util.*

class BrandDtoAssert(brandDto: BrandDto) : AbstractAssert<BrandDtoAssert, BrandDto>(brandDto, BrandDtoAssert::class.java) {

    companion object {
        fun assertThat(brandDto: BrandDto) : BrandDtoAssert {
            return BrandDtoAssert(brandDto)
        }
    }

    fun hasId(id : Long) : BrandDtoAssert {
        isNotNull
        if (!Objects.equals(id, actual.id)) {
            failWithMessage(
                    "Expected character's name to be <%s> but was <%s>", id, actual.id)
        }
        return this
    }

    fun hasName(name : String) : BrandDtoAssert {
        isNotNull
        if (!Objects.equals(name, actual.name)) {
            failWithMessage(
                    "Expected character's name to be <%s> but was <%s>", name, actual.name)
        }
        return this
    }
}
