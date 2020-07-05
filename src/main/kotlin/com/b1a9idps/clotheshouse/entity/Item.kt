package com.b1a9idps.clotheshouse.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Item (
        var brandId: Long,
        var genreId: Long,
        var colorId: Long,
        var imageUrl: String,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = -1
)
