package com.wearefrancis.mediarate.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport


@Configuration
open class WebMvcConfig: WebMvcConfigurationSupport() {
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val converter = MappingJackson2HttpMessageConverter()
        val module = SimpleModule()
        module.addDeserializer(String::class.java, WhiteSpaceRemovalDeserializer())
        val mapper = ObjectMapper()
        mapper.registerModule(module)
        converter.objectMapper = mapper
    }
}