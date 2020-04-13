package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository : JpaRepository<Brand, Long> {
}
