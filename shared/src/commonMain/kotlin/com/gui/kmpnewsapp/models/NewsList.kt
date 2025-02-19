package com.gui.kmpnewsapp.models

@kotlinx.serialization.Serializable
data class NewsList (
    var articles: List<NewsItem>? = null
)