package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.service.ItemService
import com.b1a9idps.clotheshouse.service.dto.BrandDto
import com.b1a9idps.clotheshouse.service.dto.ColorDto
import com.b1a9idps.clotheshouse.service.dto.GenreDto
import com.b1a9idps.clotheshouse.service.dto.ItemDto
import org.springframework.stereotype.Service
import java.net.URI

@Service
class ItemServiceImpl : ItemService {
    override fun list() : List<ItemDto> {
        val item1 = ItemDto(
                1,
                URI("https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-207a.jpg"),
                BrandDto(1, "ETHOSENS"),
                ColorDto(1, "Black"),
                GenreDto(1, "Shirts"))
        val item2 = ItemDto(
                2,
                URI("https://www.ethosens.com/onlinestore/wp-content/uploads/2019/12/e120-207a.jpg"),
                BrandDto(1, "ETHOSENS"),
                ColorDto(1, "Black"),
                GenreDto(1, "Shirts"))
        return listOf(item1, item2)
    }
}
