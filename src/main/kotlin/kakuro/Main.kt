package kakuro

import java.util.Scanner

fun main(args: Array<String>) {
    val game = KakuroGame()
    while(true) {
        println(game.board)
        var x = inputNum("X: ")
        var y = inputNum("Y: ")
        var v = inputNum("Value: ")
        game.put(x, y, v)
        if(game.isCompleted()) {
            break
        }
    }
}

fun inputNum(message:String):Int {
    var result:Int
    val scanner = Scanner(System.`in`)

    print(message)
    while(true) {
        try {
            result = Integer.parseInt(scanner.nextLine())
            break
        } catch (t:Throwable) {
            println("Please input an integer.")
        }
    }
    return result
}
