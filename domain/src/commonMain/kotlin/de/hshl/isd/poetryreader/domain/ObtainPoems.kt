package de.hshl.isd.poetryreader.domain

interface ObtainPoems {
    suspend fun getAPoem() : String
}