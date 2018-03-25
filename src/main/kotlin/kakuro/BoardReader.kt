package kakuro

import java.nio.file.*

fun loadGame(path:String):KakuroGame = KakuroGame(loadBoard(path))
fun loadBoard(path:String):KakuroBoard {
    val file = Paths.get(path)
    val lines = Files.readAllLines(file)
    return KakuroBoard(
        lines.map{
            it.split(',').map{ convertToCell(it) }.toTypedArray()
        }.toTypedArray()
    )
}

private fun convertToCell(term:String):Cell = when {
    term.isEmpty() -> BLANK
    term == "\\" -> NA
    term.contains("\\") -> convertToQCell(term)
    else -> throw IllegalArgumentException("Illegal Term: $term")
}

private fun convertToQCell(term:String):QCell {
    val numbers = term.split("\\")
    if(numbers.size != 2) {
        throw IllegalArgumentException("Illegal Quiz Cell: $term")
    }
    return QCell(numbers[0].toInt(), numbers[1].toInt())
}
