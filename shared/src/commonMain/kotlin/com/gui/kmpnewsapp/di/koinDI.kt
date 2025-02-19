package com.gui.kmpnewsapp.di

import com.gui.kmpnewsapp.networking.NetworkClient
import com.gui.kmpnewsapp.service.NewsService
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.dsl.module
//import ru.azharkova.otusnewskmpcompose.usecase.NewsUseCase
//import ru.azharkova.otusnewskmpcompose.viewmodel.NewsViewModel
import kotlin.reflect.KClass


class KoinDI : KoinComponent {
    val serviceModule = module {
        single { NetworkClient() }
        single { NewsService(get()) }
    }

//    val usecaseModule = module {
//        factory {
//            NewsUseCase(get())
//        }
//    }

//    val vmModule = module {
//        factory<NewsViewModel> { NewsViewModel(get()) }
//    }

    fun start() = startKoin {
        modules(listOf(serviceModule))
//        modules(listOf(serviceModule, usecaseModule, vmModule))
    }
}

object KoinDIFactory {
    val di by lazy {
        KoinDI().apply {
            start()
        }
    }
}

fun<T:Any> KoinDIFactory.resolve(clazz: KClass<*>):T? {
    return di.getKoin().get(clazz)
}