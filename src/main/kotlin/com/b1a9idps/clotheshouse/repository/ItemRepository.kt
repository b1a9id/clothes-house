package com.b1a9idps.clotheshouse.repository

import com.b1a9idps.clotheshouse.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>
