package ch.bharanya

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Journal(journalFile: File) {
    val entries: List<JournalEntry>

    private fun readAllEntries(journalFile: File): List<JournalEntry> {
        val entries = ArrayList<JournalEntry>()

        val journalLines = journalFile.readLines()

        var currentEntry: JournalEntry? = null
        for (line: String in journalLines) {
            val trimmedLine = line.trim()
            val patternString = "yyyy-MM-dd HH:mm"
            val pattern = DateTimeFormatter.ofPattern(patternString)
            try {
                val foundDateTime = LocalDateTime.parse(trimmedLine.substring(0, patternString.length), pattern)
                if (currentEntry != null){
                    entries.add(currentEntry)
                }
                val restOfLine = trimmedLine.substring(patternString.length + 1, trimmedLine.length)
                currentEntry = JournalEntry(foundDateTime, restOfLine)
            } catch (e: Exception) {
                if (trimmedLine.isNotBlank())
                    currentEntry?.text = currentEntry?.text + "\n" + trimmedLine
            }
        }
        if (currentEntry != null){
            entries.add(currentEntry)
        }


        return entries
    }

    init {
        this.entries = readAllEntries(journalFile)
    }

}