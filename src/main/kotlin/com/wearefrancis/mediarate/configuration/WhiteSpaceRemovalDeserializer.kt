package com.wearefrancis.mediarate.configuration

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class WhiteSpaceRemovalDeserializer: JsonDeserializer<String>() {
    override fun deserialize(parser: JsonParser?, context: DeserializationContext?): String
            = parser!!.currentToken.asString().trim()
}