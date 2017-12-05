package ch.bharanya

import io.javalin.Javalin
import java.time.LocalDateTime

fun main(args: Array<String>) {
    val app = Javalin.start(7000)
    app.get("/") { ctx ->
        ctx.json(JournalEntry(LocalDateTime.now(), "Test"))
    }
}