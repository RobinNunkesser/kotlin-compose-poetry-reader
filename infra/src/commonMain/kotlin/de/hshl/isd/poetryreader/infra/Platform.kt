package de.hshl.isd.poetryreader.infra

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform