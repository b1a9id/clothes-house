package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Brand
import com.b1a9idps.clotheshouse.entity.Category
import com.b1a9idps.clotheshouse.entity.Color
import com.b1a9idps.clotheshouse.entity.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository : JpaRepository<Genre, Long> {
}
