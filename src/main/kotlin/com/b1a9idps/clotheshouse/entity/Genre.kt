package com.b1a9idps.clotheshouse.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Genre(
        var name: String,
        var categoryId: Long,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
)
