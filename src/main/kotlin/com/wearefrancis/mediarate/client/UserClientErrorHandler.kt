package com.wearefrancis.mediarate.client

import com.wearefrancis.mediarate.exception.BadCredentialsException
import com.wearefrancis.mediarate.exception.ForbiddenException
import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus
import java.lang.Exception

class UserClientErrorHandler: ErrorDecoder {
    override fun decode(method: String?, response: Response?): Exception = when (response!!.status()) {
        HttpStatus.UNAUTHORIZED.value() -> BadCredentialsException()
        HttpStatus.FORBIDDEN.value() -> ForbiddenException()
        else -> Exception(response.reason())
    }
}