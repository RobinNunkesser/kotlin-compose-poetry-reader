package de.hshl.isd.poetryreader.infra

import kotlinx.coroutines.runBlocking
import org.junit.Test

class PoemFileAdapterTests {
    @Test
    fun getAPoem() {
        assert(runBlocking { PoemFileAdapter().getAPoem() }
            .startsWith("Comme je descendais des Fleuves impassibles"))
    }
}