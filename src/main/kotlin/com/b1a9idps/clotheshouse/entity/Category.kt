package com.b1a9idps.clotheshouse.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Category(
        var name: String,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
)
