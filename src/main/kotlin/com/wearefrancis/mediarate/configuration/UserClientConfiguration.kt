package com.wearefrancis.mediarate.configuration

import com.wearefrancis.mediarate.client.UserClientErrorHandler
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class UserClientConfiguration {
    @Bean
    open fun errorDecoder(): ErrorDecoder = UserClientErrorHandler()
}