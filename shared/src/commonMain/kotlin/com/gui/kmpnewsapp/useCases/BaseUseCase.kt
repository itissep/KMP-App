package com.gui.kmpnewsapp.useCases

import com.gui.kmpnewsapp.utils.ioDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in T, out R>(
    private val dispatcher: CoroutineDispatcher = ioDispatcher
) {

    abstract suspend fun execute(param: T): R

    suspend operator fun invoke(param: T): Result<R> = withContext(dispatcher) {
        runCatching { execute(param) }
    }
}