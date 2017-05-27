package com.wearefrancis.mediarate.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.wearefrancis.mediarate.NAME_MAX_LENGTH
import com.wearefrancis.mediarate.NAME_MIN_LENGTH
import com.wearefrancis.mediarate.configuration.WhiteSpaceRemovalDeserializer
import javax.validation.constraints.Size

data class WriteArtistDTO(
        @JsonDeserialize(using = WhiteSpaceRemovalDeserializer::class)
        @get:Size(max = NAME_MAX_LENGTH, min = NAME_MIN_LENGTH)
        val firstName: String,

        @JsonDeserialize(using = WhiteSpaceRemovalDeserializer::class)
        @get:Size(max = NAME_MAX_LENGTH, min = NAME_MIN_LENGTH)
        val lastName: String
)