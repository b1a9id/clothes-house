package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Item
import com.b1a9idps.clotheshouse.repository.ItemRepository
import com.b1a9idps.clotheshouse.service.BrandService
import com.b1a9idps.clotheshouse.service.ColorService
import com.b1a9idps.clotheshouse.service.GenreService
import com.b1a9idps.clotheshouse.service.ItemService
import com.b1a9idps.clotheshouse.service.dto.ItemDto
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(
        val itemRepository: ItemRepository,
        val brandService: BrandService,
        val colorService: ColorService,
        val genreService: GenreService) : ItemService {

    override fun list() : List<ItemDto> {
        val items = itemRepository.findAll()

        val itemDtoList: MutableList<ItemDto> = mutableListOf()
        for (item in items) {
            itemDtoList.add(convert(item))
        }
        return itemDtoList
    }

    override fun get(id: Long): ItemDto {
        return itemRepository.findById(id)
                .map{ item -> convert(item) }
                .orElse(null)
    }

    private fun convert(item : Item) : ItemDto {
        val brand = brandService.get(item.brandId)
        val color = colorService.get(item.colorId)
        val genre = genreService.get(item.genreId)

        return ItemDto.newInstance(item, brand, color, genre)
    }
}
