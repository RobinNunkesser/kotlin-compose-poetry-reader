package de.hshl.isd.poetryreader.infra

import de.hshl.isd.poetryreader.domain.ObtainPoems

class PoemFileAdapter : ObtainPoems {

    override suspend fun getAPoem(): String {
        val content = this::class.java.getResource("/Poetry.json").readText()
        val poems = Poems.fromJson(content)
        return poems!!.poems.first().poem
    }

}