package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Brand
import com.b1a9idps.clotheshouse.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}
