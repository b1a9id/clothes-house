package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
        @SequenceGenerator(name = "category_seq_gen", sequenceName = "category_seq", allocationSize = 1)
        var id: Long,
        var name: String
)
