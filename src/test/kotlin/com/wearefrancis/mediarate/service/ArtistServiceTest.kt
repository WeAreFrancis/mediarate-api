package com.wearefrancis.mediarate.service

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.wearefrancis.mediarate.domain.Artist
import com.wearefrancis.mediarate.dto.ReadArtistDTO
import com.wearefrancis.mediarate.dto.WriteArtistDTO
import com.wearefrancis.mediarate.dto.mapper.ReadArtistDTOMapper
import com.wearefrancis.mediarate.repository.ArtistRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class ArtistServiceTest {
    private lateinit var artistRepository: ArtistRepository
    private lateinit var artistService: ArtistService
    private lateinit var readArtistDTOMapper: ReadArtistDTOMapper

    @Before
    fun setUp() {
        artistRepository = mock<ArtistRepository>()
        readArtistDTOMapper = mock<ReadArtistDTOMapper>()
        artistService = ArtistService(
                artistRepository = artistRepository,
                readArtistDTOMapper = readArtistDTOMapper
        )
    }

    @Test
    fun createShouldCreateArtistAndReturnIt() {
        // GIVEN
        val writeArtistDTO = WriteArtistDTO(
                firstName = "Kevin",
                lastName = "Spacey"
        )
        val readArtistDTO = ReadArtistDTO(
                firstName = writeArtistDTO.firstName,
                id = UUID.randomUUID(),
                lastName = writeArtistDTO.lastName
        )
        whenever(artistRepository.save(any<Artist>())).then(fun (invocation): Artist {
            val artist = invocation.getArgumentAt(0, Artist::class.java)
            assertThat(artist.firstName).isEqualTo(writeArtistDTO.firstName)
            assertThat(artist.lastName).isEqualTo(writeArtistDTO.lastName)
            return artist
        })
        whenever(readArtistDTOMapper.convert(any<Artist>())).thenReturn(readArtistDTO)

        // WHEN
        val artistDTO = artistService.create(writeArtistDTO)

        // THEN
        assertThat(artistDTO).isSameAs(readArtistDTO)
        verify(artistRepository).save(any<Artist>())
        verify(readArtistDTOMapper).convert(any<Artist>())
    }
}