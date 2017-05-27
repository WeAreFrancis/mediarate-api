package com.wearefrancis.mediarate.dto

import org.springframework.security.core.GrantedAuthority
import java.util.*

data class ReadUserDTO(
        val id: UUID,
        val role: Role,
        val username: String
) {
    enum class Role : GrantedAuthority {
        USER,
        ADMIN,
        SUPER_ADMIN;

        override fun getAuthority(): String {
            return name
        }
    }
}