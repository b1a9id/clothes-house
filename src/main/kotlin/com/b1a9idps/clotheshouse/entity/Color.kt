package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
class Color(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_seq_gen")
        @SequenceGenerator(name = "color_seq_gen", sequenceName = "color_seq", allocationSize = 1)
        var id: Long,
        var name: String
)
