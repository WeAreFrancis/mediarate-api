package com.wearefrancis.mediarate.domain

import com.wearefrancis.mediarate.NAME_MAX_LENGTH
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "artists")
data class Artist(
        @Column(length = NAME_MAX_LENGTH, nullable = false)
        val firstName: String = "",

        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Id
        val id: UUID = UUID.randomUUID(),

        @Column(length = NAME_MAX_LENGTH, nullable = false)
        val lastName: String = ""
)