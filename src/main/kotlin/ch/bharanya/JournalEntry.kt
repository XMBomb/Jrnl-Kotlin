package ch.bharanya

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class JournalEntry {
    val dateTime: LocalDateTime
    val text: String

    constructor(dateTime: LocalDateTime, text: String) {
        this.dateTime = dateTime
        this.text = text
    }

    constructor(fromString: String) {
        this.dateTime = getDateTimeFrom(fromString)
        this.text = getTextFrom(fromString)
    }

    private fun getTextFrom(fromString: String): String {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm ")

        return fromString.substring(LocalDateTime.now().format(pattern).length)
    }

    private fun getDateTimeFrom(string: String): LocalDateTime {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val split = string.split(' ')
        return LocalDateTime.parse(split[0] + " " + split[1], pattern)
    }
}