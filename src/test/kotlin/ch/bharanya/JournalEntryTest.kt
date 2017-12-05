package ch.bharanya

import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

class JournalEntryTest {
    @Test
    fun testEntryFromString(){
        val entry = JournalEntry("2017-12-01 21:19 Mi Unify AC Pro ufgsetzt")

        Assert.assertEquals(LocalDateTime.of(2017,12,1,21,19), entry.dateTime)
        Assert.assertEquals("Mi Unify AC Pro ufgsetzt", entry.text)
    }
}