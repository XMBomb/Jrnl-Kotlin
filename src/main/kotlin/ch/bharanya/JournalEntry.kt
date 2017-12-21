package ch.bharanya

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class JournalEntry(val dateTime: LocalDateTime, var text: String){
    override fun toString(): String = "${dateTime.format(DateTimeFormatter.ofPattern(Journal.DATE_FORMAT))} $text"
}