package com.wearefrancis.mediarate.service

import com.wearefrancis.mediarate.domain.Artist
import com.wearefrancis.mediarate.dto.ReadArtistDTO
import com.wearefrancis.mediarate.dto.WriteArtistDTO
import com.wearefrancis.mediarate.dto.mapper.ReadArtistDTOMapper
import com.wearefrancis.mediarate.exception.EntityNotFoundException
import com.wearefrancis.mediarate.repository.ArtistRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArtistService(
        private val artistRepository: ArtistRepository,
        private val readArtistDTOMapper: ReadArtistDTOMapper
) {
    companion object {
        val logger = LoggerFactory.getLogger(ArtistService::class.java)!!
    }

    fun create(artistDTO: WriteArtistDTO): ReadArtistDTO {
        val artist = artistRepository.save(Artist(
                firstName = artistDTO.firstName,
                lastName = artistDTO.lastName
        ))
        logger.info("Artist ${artist.firstName} ${artist.lastName} (${artist.id}) created")
        return readArtistDTOMapper.convert(artist)
    }

    fun getById(id: UUID): ReadArtistDTO {
        val artist = artistRepository.findOne(id) ?: throw EntityNotFoundException("Artist $id not found")
        return readArtistDTOMapper.convert(artist)
    }

    fun search(firstName: String, lastName: String): List<ReadArtistDTO> {
        val artists = artistRepository.findAllByFirstNameLikeAndLastNameLike(firstName, lastName)
        return artists.map(readArtistDTOMapper::convert)
    }
}