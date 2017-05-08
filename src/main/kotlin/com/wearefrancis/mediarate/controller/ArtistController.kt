package com.wearefrancis.mediarate.controller

import com.wearefrancis.mediarate.dto.ReadArtistDTO
import com.wearefrancis.mediarate.dto.WriteArtistDTO
import com.wearefrancis.mediarate.service.ArtistService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/artists")
@RestController
class ArtistController(
        private val artistService: ArtistService
) {
    @PostMapping
    fun create(@RequestBody @Valid artistDTO: WriteArtistDTO): ReadArtistDTO = artistService.create(artistDTO)
}