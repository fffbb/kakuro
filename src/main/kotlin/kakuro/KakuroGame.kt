package kakuro

class KakuroGame(val board:KakuroBoard) {
    fun put(x:Int, y:Int, v:Int) {
        if(board.isQuiz(x, y)) {
            throw IllegalArgumentException("($x, $y) is quiz cell.")
        }

        val old:Int = board.getValue(x, y)
        board.put(x, y, v)
        if(board.getHorizontalQuiz(x, y) < board.getHorizontalSum(x, y)) {
            throw IllegalArgumentException("Too Much:Horizontal")
        }
        if(board.getVerticalQuiz(x, y) < board.getVerticalSum(x, y)) {
            throw IllegalArgumentException("Too Much:Vertical")
        }
    }

    fun isCompleted():Boolean {
        return board.isCompleted()
    }
}
