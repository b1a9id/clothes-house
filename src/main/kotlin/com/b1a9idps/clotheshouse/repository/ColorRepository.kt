package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ColorRepository : JpaRepository<Color, Long>
