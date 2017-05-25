package com.wearefrancis.mediarate.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class BadCredentialsException : RuntimeException("Bad credentials")