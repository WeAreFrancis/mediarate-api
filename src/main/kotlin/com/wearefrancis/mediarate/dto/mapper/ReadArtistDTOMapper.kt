package com.wearefrancis.mediarate.dto.mapper

import com.wearefrancis.mediarate.domain.Artist
import com.wearefrancis.mediarate.dto.ReadArtistDTO
import org.springframework.stereotype.Component

@Component
open class ReadArtistDTOMapper: Mapper<Artist, ReadArtistDTO> {
    override fun convert(model: Artist): ReadArtistDTO = ReadArtistDTO(
            firstName = model.firstName,
            id = model.id,
            lastName = model.lastName
    )
}