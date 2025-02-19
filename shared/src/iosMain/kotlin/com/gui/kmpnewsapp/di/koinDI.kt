package com.gui.kmpnewsapp.di

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import platform.Foundation.NSClassFromString
import kotlin.reflect.KClass

@OptIn(BetaInteropApi::class) fun<T:Any> createType(clazz: String): KClass<*>? {
    val objCClass = NSClassFromString(clazz)
    if (objCClass != null) {
        return getOriginalKotlinClass(objCClass)
    }
    return null // no type found
}

@OptIn(BetaInteropApi::class) fun<T:Any> KoinDIFactory.createType(clazz: ObjCClass): KClass<*>? {
    return getOriginalKotlinClass(clazz)
}


@OptIn(BetaInteropApi::class) fun<T:Any> KoinDIFactory.resolve(clazz: ObjCClass):T? {
    val kClass = createType<T>(clazz)
    if (kClass != null) {
        return di.getKoin().get(kClass)
    }
    return null
}