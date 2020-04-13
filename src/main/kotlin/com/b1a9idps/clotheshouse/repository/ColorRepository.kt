package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Brand
import com.b1a9idps.clotheshouse.entity.Category
import com.b1a9idps.clotheshouse.entity.Color
import org.springframework.data.jpa.repository.JpaRepository

interface ColorRepository : JpaRepository<Color, Long> {
}
