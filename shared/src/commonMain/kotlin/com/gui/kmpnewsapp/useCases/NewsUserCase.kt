package com.gui.kmpnewsapp.useCases

import com.gui.kmpnewsapp.models.NewsList
import com.gui.kmpnewsapp.service.NewsService

class NewsUseCase (private val newsService: NewsService): BaseUseCase<Unit, NewsList?>() {
    override suspend fun execute(param: Unit): NewsList? {
        return try {
            newsService.loadNews().getOrNull()
        }catch (e: Exception) {
            throw e
        }
    }
}