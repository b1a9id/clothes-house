package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
class Brand(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq_gen")
        @SequenceGenerator(name = "brand_seq_gen", sequenceName = "brand_seq", allocationSize = 1)
        var id: Long,
        var name: String
)
