package com.gui.kmpnewsapp.networking

class NetworkConfig {
    companion object shared {
        val apiUrl = "newsapi.org"
        val apiKey = "2f7740c6d4ec46be9bf158176fe3271e"

        val header: HashMap<String, String> =  hashMapOf("X-Api-Key" to apiKey)
    }
}