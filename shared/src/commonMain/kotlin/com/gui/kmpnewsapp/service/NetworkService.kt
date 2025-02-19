package com.gui.kmpnewsapp.service

import com.gui.kmpnewsapp.models.NewsList
import com.gui.kmpnewsapp.networking.NetworkClient
import com.gui.kmpnewsapp.networking.NetworkConfig

class NewsService(private val httpClient: NetworkClient) {

    suspend fun loadNews(): Result<NewsList> {
        return httpClient.request(URL)
    }

    companion object {
        val  URL = "https://newsapi.org/v2/everything?q=science&apiKey=${NetworkConfig.apiKey}"
    }
}