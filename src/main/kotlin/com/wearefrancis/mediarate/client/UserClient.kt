package com.wearefrancis.mediarate.client

import com.wearefrancis.mediarate.configuration.UserClientConfiguration
import com.wearefrancis.mediarate.dto.ReadUserDTO
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(configuration = arrayOf(UserClientConfiguration::class), name = "userClient", url = "\${client.user.url}")
interface UserClient {
    @GetMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun self(@RequestHeader(HttpHeaders.AUTHORIZATION) authorization: String): ReadUserDTO
}