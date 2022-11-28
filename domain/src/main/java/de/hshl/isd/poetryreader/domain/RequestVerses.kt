package de.hshl.isd.poetryreader.domain

interface RequestVerses {
    suspend fun giveMeSomePoetry() : String
}

