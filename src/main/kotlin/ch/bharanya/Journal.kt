package ch.bharanya

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class Journal {
    val entries: List<JournalEntry>

    constructor(journalFile: File) {
        this.entries = readAllEntries(journalFile)
    }

    private fun readAllEntries(journalFile: File): List<JournalEntry> {
        val entries = ArrayList<JournalEntry>()

        val journalLines = journalFile.readLines()

        val entryText = StringBuilder()
        var currentEntry: JournalEntry? = null
        for (line: String in journalLines) {
            val strippedLine = line.trim()
            val patternString = "yyyy-MM-dd HH:mm"
            val pattern = DateTimeFormatter.ofPattern(patternString)
            try {
                val foundDateTime = LocalDateTime.parse(strippedLine.substring(0, patternString.length), pattern)
                if (currentEntry != null){
                    entries.add(currentEntry)
                }
                val restOfLine = strippedLine.substring(patternString.length + 1, strippedLine.length)
                entryText.appendln(restOfLine)
                currentEntry = JournalEntry(foundDateTime, entryText.toString())
            } catch (e: Exception) {
                entryText.appendln(strippedLine)
            }
        }


        return entries
    }

}