package de.hshl.isd.poetryreader.infra

import de.hshl.isd.poetryreader.domain.PoetryReader

class ConsoleAdapter(private var poetryReader: PoetryReader,
                     private var writeStrategy: WriteStuffOnTheConsole = DefaultPublicationStrategy()) {

    suspend fun ask() {
        // Adapt from the infra to the domain

        // Call the business logic
        var verses = this.poetryReader.giveMeSomePoetry();

        // Adapt from Domain to Infra
        this.writeStrategy.writeLine("A beautiful poem:\n\n$verses");
    }

    class DefaultPublicationStrategy : WriteStuffOnTheConsole {
        override fun writeLine(text: String) {
            println(text)
        }

    }
}