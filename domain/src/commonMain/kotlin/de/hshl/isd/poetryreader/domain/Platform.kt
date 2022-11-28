package de.hshl.isd.poetryreader.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform