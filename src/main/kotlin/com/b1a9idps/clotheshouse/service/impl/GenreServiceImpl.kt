package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Genre
import com.b1a9idps.clotheshouse.repository.GenreRepository
import com.b1a9idps.clotheshouse.service.GenreService
import com.b1a9idps.clotheshouse.service.dto.GenreDto
import org.springframework.stereotype.Service

@Service
class GenreServiceImpl(val genreRepository: GenreRepository) : GenreService {

    private val genreDtoTransformer : (Genre) -> GenreDto =
            {genre -> GenreDto.newInstance(genre)}

    override fun list() : List<GenreDto> {
        return genreRepository.findAll().map(genreDtoTransformer)
    }

    override fun get(id : Long): GenreDto {
        return genreRepository.findById(id)
                .map(genreDtoTransformer)
                .orElse(null)
    }
}
