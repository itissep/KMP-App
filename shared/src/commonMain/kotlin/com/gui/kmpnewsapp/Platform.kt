package com.gui.kmpnewsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform