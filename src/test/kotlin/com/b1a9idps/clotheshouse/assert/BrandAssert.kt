package com.b1a9idps.clotheshouse.assert

import com.b1a9idps.clotheshouse.entity.Brand
import org.assertj.core.api.AbstractAssert
import java.util.*

class BrandAssert(brand: Brand) : AbstractAssert<BrandAssert, Brand>(brand, BrandAssert::class.java) {

    companion object {
        fun assertThat(brand: Brand) : BrandAssert {
            return BrandAssert(brand)
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
