package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
class Genre(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq_gen")
        @SequenceGenerator(name = "genre_seq_gen", sequenceName = "genre_seq", allocationSize = 1)
        var id: Long,
        var name: String,
        var categoryId: Long
)
