package com.wearefrancis.mediarate.controller

import com.wearefrancis.mediarate.UUID_REGEX
import com.wearefrancis.mediarate.dto.ReadArtistDTO
import com.wearefrancis.mediarate.dto.WriteArtistDTO
import com.wearefrancis.mediarate.service.ArtistService
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RequestMapping("/artists")
@RestController
class ArtistController(
        private val artistService: ArtistService
) {
    @PostMapping
    fun create(@RequestBody @Valid artistDTO: WriteArtistDTO): ReadArtistDTO = artistService.create(artistDTO)

    @GetMapping("/{artistId:$UUID_REGEX}")
    fun getById(@PathVariable artistId: UUID): ReadArtistDTO = artistService.getById(artistId)
}