package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>
