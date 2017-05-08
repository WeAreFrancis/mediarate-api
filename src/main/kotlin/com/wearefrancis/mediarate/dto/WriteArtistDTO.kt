package com.wearefrancis.mediarate.dto

import com.wearefrancis.mediarate.NAME_MAX_LENGTH
import com.wearefrancis.mediarate.NAME_MIN_LENGTH
import javax.validation.constraints.Size

data class WriteArtistDTO(
        @get:Size(max = NAME_MAX_LENGTH, min = NAME_MIN_LENGTH)
        val firstName: String,

        @get:Size(max = NAME_MAX_LENGTH, min = NAME_MIN_LENGTH)
        val lastName: String
)