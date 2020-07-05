package com.b1a9idps.clotheshouse

import org.mockito.Mockito

class TestUtils {
    companion object {
        fun <T> any(clazz : Class<T>) : T {
            return Mockito.any(clazz)
        }
    }
}
