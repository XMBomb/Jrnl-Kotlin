package ch.bharanya

import java.time.LocalDateTime

class JournalEntry {
    val dateTime: LocalDateTime
    val text: String

    constructor(dateTime: LocalDateTime, text: String) {
        this.dateTime = dateTime
        this.text = text
    }
}