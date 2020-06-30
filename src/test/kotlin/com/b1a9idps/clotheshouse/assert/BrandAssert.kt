package com.b1a9idps.clotheshouse.assert

import com.b1a9idps.clotheshouse.service.dto.BrandDto
import org.assertj.core.api.AbstractAssert
import java.util.*

class BrandAssert(brandDto: BrandDto) : AbstractAssert<BrandAssert, BrandDto>(brandDto, BrandAssert::class.java) {

    companion object {
        fun assertThat(brandDto: BrandDto) : BrandAssert {
            return BrandAssert(brandDto)
        }
    }

    fun hasId(id : Long) : BrandAssert {
        isNotNull
        if (!Objects.equals(id, actual.id)) {
            failWithMessage(
                    "Expected character's name to be <%s> but was <%s>", id, actual.id)
        }
        return this
    }

    fun hasName(name : String) : BrandAssert {
        isNotNull
        if (!Objects.equals(name, actual.name)) {
            failWithMessage(
                    "Expected character's name to be <%s> but was <%s>", name, actual.name)
        }
        return this
    }
}
