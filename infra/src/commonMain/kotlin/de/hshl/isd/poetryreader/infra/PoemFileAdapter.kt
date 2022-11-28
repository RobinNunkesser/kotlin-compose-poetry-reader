package de.hshl.isd.poetryreader.infra

import de.hshl.isd.poetryreader.domain.ObtainPoems

class PoemFileAdapter : ObtainPoems {

    override suspend fun getAPoem(): String {
        val content = MR.files.Poetry.getText()
        val poems = Poems.fromJson(content)
        return poems!!.poems.first().poem
    }

}