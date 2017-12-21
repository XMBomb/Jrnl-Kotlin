package ch.bharanya

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Journal(journalFile: File) {
    val entries: MutableList<JournalEntry>
    companion object {
        const val DATE_FORMAT = "yyyy-MM-dd HH:mm"
    }

    init {
        this.entries = readAllEntries(journalFile)
    }


    private fun readAllEntries(journalFile: File): MutableList<JournalEntry> {
        val entries = ArrayList<JournalEntry>()

        val journalLines = journalFile.readLines()

        var currentEntry: JournalEntry? = null
        for (line: String in journalLines) {
            val trimmedLine = line.trim()
            val patternString = DATE_FORMAT
            val pattern = DateTimeFormatter.ofPattern(patternString)
            try {
                val foundDateTime = LocalDateTime.parse(trimmedLine.substring(0, patternString.length), pattern)
                if (currentEntry != null) {
                    entries.add(currentEntry)
                }
                val restOfLine = trimmedLine.substring(patternString.length + 1, trimmedLine.length)
                currentEntry = JournalEntry(foundDateTime, restOfLine)
            } catch (e: Exception) {
                if (trimmedLine.isNotBlank())
                    currentEntry?.let {
                        it.text += "\n$trimmedLine"
                    }
            }
        }
        if (currentEntry != null) {
            entries.add(currentEntry)
        }

        return entries
    }

    fun add(entry: JournalEntry){
        this.entries.add(entry)
    }

    fun write(journalFile: File){
        journalFile.writeText(this.entries.map { it.toString() }.joinToString("\n\n"))
    }

}