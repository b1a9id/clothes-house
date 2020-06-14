package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
data class Item (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
        @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_seq", allocationSize = 1)
        val id: Long? = null,
        val brandId: Long? = null,
        val genreId: Long? = null,
        val colorId: Long? = null,
        val imageUrl: String? = null
)
