package com.wearefrancis.mediarate.dto.mapper

import com.wearefrancis.mediarate.domain.Artist
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ReadArtistDTOMapperTest {
    private lateinit var readArtistDTOMapper: ReadArtistDTOMapper

    @Before
    fun setUp() {
        readArtistDTOMapper = ReadArtistDTOMapper()
    }

    @Test
    fun convertShouldConvertArtistToReadArtistDTO() {
        // GIVEN
        val artist = Artist(
                firstName = "Kevin",
                lastName = "Spacey"
        )

        // WHEN
        val artistDTO = readArtistDTOMapper.convert(artist)

        // THEN
        assertThat(artistDTO.firstName).isEqualTo(artist.firstName)
        assertThat(artistDTO.id).isEqualTo(artist.id)
        assertThat(artistDTO.lastName).isEqualTo(artist.lastName)
    }
}