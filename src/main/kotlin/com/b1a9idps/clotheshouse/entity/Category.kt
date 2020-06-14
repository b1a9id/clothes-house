package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
        @SequenceGenerator(name = "category_seq_gen", sequenceName = "category_seq", allocationSize = 1)
        val id: Long? = null,
        val name: String? = null
)
