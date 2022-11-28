package de.hshl.isd.poetryreader.domain

class PoetryReader(private var poetryLibrary: ObtainPoems? = null) : RequestVerses {

    override suspend fun giveMeSomePoetry(): String =
        poetryLibrary?.getAPoem() ?: "If you could read a leaf or tree\nyou’d have no need of books.\n-- © Alistair Cockburn (1987)"

}