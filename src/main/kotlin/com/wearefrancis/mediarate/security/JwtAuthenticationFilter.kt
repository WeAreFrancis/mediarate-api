package com.wearefrancis.mediarate.security

import com.wearefrancis.mediarate.client.UserClient
import com.wearefrancis.mediarate.exception.BadCredentialsException
import com.wearefrancis.mediarate.exception.ForbiddenException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
open class JwtAuthenticationFilter(
        private val userClient: UserClient
): OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest?, response: HttpServletResponse?, filterChain: FilterChain?
    ) {
        val authorizationValue = request!!.getHeader(HttpHeaders.AUTHORIZATION)
        try {
            val user = userClient.self(authorizationValue)
            val authentication = UsernamePasswordAuthenticationToken(user, null, listOf(user.role))
            authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authentication
            logger.info("User ${user.username} authenticated")
        } catch (exception: BadCredentialsException){
            response!!.sendError(HttpStatus.UNAUTHORIZED.value())
        } catch (exception: ForbiddenException) {
            response!!.sendError(HttpStatus.FORBIDDEN.value())
        }
    }
}