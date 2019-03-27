package com.yhklsdf.mvp.model

import com.squareup.moshi.Json

data class YiYanSentence(
        @Json(name = "id") val sentence: String,
        @Json(name = "type") val type: Char,
        @Json(name = "from") val from: String,
        @Json(name = "creator") val creator : String
)