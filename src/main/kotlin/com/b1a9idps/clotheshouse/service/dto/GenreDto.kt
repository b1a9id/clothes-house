package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.entity.Genre

data class GenreDto (
        val id: Long,
        val name: String,
        val category: CategoryDto?) {
    companion object {
        fun newInstance(genre: Genre, category: CategoryDto?) : GenreDto {
            return GenreDto(genre.id, genre.name, category)
        }
    }
}
