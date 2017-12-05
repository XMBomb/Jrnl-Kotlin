package ch.bharanya

import java.io.File

class Journal(val journalFile: String) {
    val entries: List<JournalEntry> = readAllEntries()

    private fun readAllEntries(): List<JournalEntry> {
        return File(journalFile).readLines().map { JournalEntry(it) }
    }


    fun addEntry(entry: JournalEntry) {

    }
}