package com.b1a9idps.clotheshouse.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Category(
        @Id
        @GeneratedValue
        val id: Long? = null,
        val name: String? = null
)
