package de.hshl.isd.poetryreader.infra

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Poems (
    val poems: List<Poem>
) {
    fun toJson() = klaxon.toJsonString(this)

    companion object {
        fun fromJson(json: String) = klaxon.parse<Poems>(json)
    }
}

data class Poem (
    val author: String,
    val title: String? = null,
    val poem: String,
    val publicationYear: String? = null
)
