package com.b1a9idps.clotheshouse.entity

import javax.persistence.*

@Entity
class Item (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
        @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_seq", allocationSize = 1)
        var id: Long,
        var brandId: Long,
        var genreId: Long,
        var colorId: Long,
        var imageUrl: String
)
