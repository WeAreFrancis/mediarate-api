package com.wearefrancis.mediarate

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Bean
import java.time.Clock

@EnableFeignClients
@SpringBootApplication
open class MediarateApplication

fun main(args: Array<String>) {
    SpringApplication.run(MediarateApplication::class.java, *args)
}