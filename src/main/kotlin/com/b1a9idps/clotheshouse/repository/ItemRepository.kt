package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {
}
