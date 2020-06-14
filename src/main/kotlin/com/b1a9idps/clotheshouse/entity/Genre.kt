package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
data class Genre(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq_gen")
        @SequenceGenerator(name = "genre_seq_gen", sequenceName = "genre_seq", allocationSize = 1)
        val id: Long? = null,
        val name: String? = null,
        val categoryId: Long? = null
)
