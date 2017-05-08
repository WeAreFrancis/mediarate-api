package com.wearefrancis.mediarate.repository

import com.wearefrancis.mediarate.domain.Artist
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ArtistRepository: CrudRepository<Artist, UUID>