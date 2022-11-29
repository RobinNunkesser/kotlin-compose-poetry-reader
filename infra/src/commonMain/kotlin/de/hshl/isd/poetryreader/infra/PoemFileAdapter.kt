package de.hshl.isd.poetryreader.infra

import de.hshl.isd.poetryreader.domain.ObtainPoems

class PoemFileAdapter : ObtainPoems {

    override suspend fun getAPoem(): String {
        val content = """
            {
    "poems" :
    [
        {
            "author" : "Arthur Rimbaud",
            "title" : "Le bateau ivre",
            "poem" : "Comme je descendais des Fleuves impassibles"
        }
    ]
    }            
        """.trimIndent()
        //MR.files.poetry.getText()
        val poems = Poems.fromJson(content)
        return poems!!.poems.first().poem
    }

}