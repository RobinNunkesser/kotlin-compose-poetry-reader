package de.hshl.isd.poetryreader.domain

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class PoetryReaderTests {
    @Test
    fun shouldGiveVersesWhenAskedForPoetry() {
        val poetryReader = PoetryReader()
        val verses = runBlocking { poetryReader.giveMeSomePoetry() }
        assertEquals("If you could read a leaf or tree\nyou’d have no need of books.\n-- © Alistair Cockburn (1987)", verses)
    }
}