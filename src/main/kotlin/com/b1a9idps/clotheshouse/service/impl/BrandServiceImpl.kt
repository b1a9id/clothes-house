package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.annotation.CustomTransactional
import com.b1a9idps.clotheshouse.entity.Brand
import com.b1a9idps.clotheshouse.exception.NotFoundException
import com.b1a9idps.clotheshouse.repository.BrandRepository
import com.b1a9idps.clotheshouse.service.BrandService
import com.b1a9idps.clotheshouse.service.dto.BrandCreateDto
import com.b1a9idps.clotheshouse.service.dto.BrandDto
import com.b1a9idps.clotheshouse.service.dto.BrandEditDto
import org.springframework.stereotype.Service

@Service
class BrandServiceImpl (val brandRepository: BrandRepository): BrandService {

    private val brandDtoTransformer : (Brand) -> BrandDto = { brand -> BrandDto.newInstance(brand) }

    override fun list(): List<BrandDto> {
        return brandRepository.findAll().mapNotNull(brandDtoTransformer)
    }

    override fun get(id : Long): BrandDto {
        return brandRepository.findById(id)
                .map(brandDtoTransformer)
                .orElse(null)
    }

    @CustomTransactional
    override fun create(brandCreateDto: BrandCreateDto) {
        brandRepository.save(Brand(brandCreateDto.name))
    }

    @CustomTransactional
    override fun edit(id: Long, brandEditDto: BrandEditDto) {
        val brand = brandRepository.findById(id).orElseThrow(::NotFoundException)
        brand.name = brandEditDto.name
        brandRepository.save(brand)
    }

    @CustomTransactional
    override fun delete(id: Long) {
        brandRepository.deleteById(id)
    }
}
