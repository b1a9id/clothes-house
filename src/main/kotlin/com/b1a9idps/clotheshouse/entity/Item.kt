package com.b1a9idps.clotheshouse.entity

import java.net.URI
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Item (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val brandId: Int? = null,
        val genreId: Int? = null,
        val colorId: Int? = null,
        val imageUrl: URI? = null
)
