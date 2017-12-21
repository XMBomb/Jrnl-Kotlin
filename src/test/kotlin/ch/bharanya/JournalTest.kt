package ch.bharanya

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.time.LocalDateTime

class JournalTest {
    private val file = File("res/journal-test.txt")

    @Test
    fun testJournalFromFile() {
        var entries = Journal(file).entries

        Assert.assertEquals(4, entries.size)

        val expectedEntries = listOf(
                JournalEntry(dateTime = LocalDateTime.of(2017, 11, 24, 23, 0), text = "1 Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                        "1.1Fusce tincidunt, ligula eget lobortis ultricies, mauris orci ultrices enim"),
                JournalEntry(dateTime = LocalDateTime.of(2017, 11, 25, 9, 0), text = "2 Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                        "2.1Fusce tincidunt, ligula eget lobortis ultricies, mauris orci ultrices enim"),
                JournalEntry(dateTime = LocalDateTime.of(2017, 11, 26, 9, 0), text = "3 Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                        "3.1Fusce tincidunt, ligula eget lobortis ultricies, mauris orci ultrices enim"),
                JournalEntry(dateTime = LocalDateTime.of(2017, 11, 27, 22, 26), text = "4 Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
        )

        Assert.assertEquals(expectedEntries, entries)
    }

    @Test
    fun testAdd() {
        val journal = Journal(file)
        val testEntry = JournalEntry(LocalDateTime.now(), "testitest")
        journal.add(testEntry)
        val lastEntry = journal.entries[journal.entries.size - 1]
        Assert.assertEquals(testEntry, lastEntry)
    }

    @Test
    fun testWrite() {
        val exportFile = File("res/journal-export-test.txt")
        Journal(file).write(exportFile)
        Assert.assertEquals(file.readText(), exportFile.readText())
    }


}
