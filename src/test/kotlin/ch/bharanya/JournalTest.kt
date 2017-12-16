package ch.bharanya
import org.junit.Assert
import org.junit.Test
import java.io.File

class JournalTest {
    @Test
    fun testJournalFromText(){
        var entries = Journal(File("res/journal-test.txt")).entries

        Assert.assertEquals(4, entries.size)
    }

}
