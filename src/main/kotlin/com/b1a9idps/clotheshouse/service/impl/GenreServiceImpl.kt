package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Genre
import com.b1a9idps.clotheshouse.repository.GenreRepository
import com.b1a9idps.clotheshouse.service.CategoryService
import com.b1a9idps.clotheshouse.service.GenreService
import com.b1a9idps.clotheshouse.service.dto.CategoryDto
import com.b1a9idps.clotheshouse.service.dto.GenreDto
import org.springframework.stereotype.Service

@Service
class GenreServiceImpl(
        val genreRepository: GenreRepository,
        val categoryService: CategoryService) : GenreService {

    private val genreDtoTransformer : (Genre, CategoryDto) -> GenreDto =
            { genre, category -> GenreDto.newInstance(genre, category)}

    override fun list() : List<GenreDto> {
        val genres = genreRepository.findAll()
        val genreDtoList : MutableList<GenreDto> = mutableListOf()
        for (genre in genres) {
            val category = categoryService.get(genre.categoryId)
            genreDtoList.add(GenreDto.newInstance(genre, category))
        }
        return genreDtoList
    }

    override fun get(id : Long): GenreDto {
        val genre = genreRepository.findById(id).get()
        val category = categoryService.get(genre.categoryId)
        return GenreDto.newInstance(genre, category)
    }
}
