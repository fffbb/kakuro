package kakuro

class KakuroBoard(var board:Array<Array<Cell>>) {
    val width = board[0].size
    val height = board.size

    fun getValue(x:Int, y:Int):Int {
        return if(board[y][x] is VCell) {
            (board[y][x] as VCell).v
        } else {
            0
        }
    }

    fun put(x:Int, y:Int, v:Int) {
        board[y][x] = VCell(v)
    }

    fun getHorizontalQuiz(x:Int, y:Int):Int {
        return (board[y][getHorizontalQx(x, y)] as QCell).h
    }

    fun getVerticalQuiz(x:Int, y:Int):Int {
        return (board[getVertialQy(x, y)][x] as QCell).v
    }

    fun getHorizontalSum(x:Int, y:Int):Int {
        if(isQuiz(x, y)) {
            throw IllegalArgumentException()
        }
        var sum = 0
        for(i in (getHorizontalQx(x, y) + 1)..(width - 1)) {
            if(isQuiz(i, y)) {
                break
            }
            sum = sum + (board[y][i] as VCell).v
        }
        return sum
    }

    fun getVerticalSum(x:Int, y:Int):Int {
        if(isQuiz(x, y)) {
            throw IllegalArgumentException()
        }
        var sum = 0
        for(i in (getVertialQy(x, y) + 1)..(height - 1)) {
            if(isQuiz(x, i)) {
                break
            }
            sum = sum + (board[i][x] as VCell).v
        }
        return sum
    }

    fun isQuiz(x:Int, y:Int):Boolean {
        return board[y][x] is QCell
    }

    fun isCompleted():Boolean {
        for(i in 0..width - 1) {
            for(j in 0.. height - 1) {
                if(isQuiz(i, j) && !isCompleted(i, j)) {
                    return false
                }
            }
        }
        return true
    }

    fun isCompleted(x:Int, y:Int):Boolean {
        if(!isQuiz(x, y)) {
            throw IllegalArgumentException()
        }

        if(getHorizontalQuiz(x, y) != 0 &&
                getHorizontalQuiz(x, y) != getHorizontalSum(x + 1, y)) {
            return false
        }
        if(getVerticalQuiz(x, y) != 0 &&
                getVerticalQuiz(x, y) != getVerticalSum(x, y + 1)) {
            return false
        }
        return true
    }

    private fun getHorizontalQx(x:Int, y:Int):Int {
        for(i in x downTo 0) {
            if(isQuiz(i, y)) {
                return i
            }
        }
        return 0
    }

    private fun getVertialQy(x:Int, y:Int):Int {
        for(i in y downTo 0) {
            if(isQuiz(x, i)) {
                return i
            }
        }
        return 0
    }

    override fun toString():String {
        var builder:StringBuilder = StringBuilder()

        for(row in board) {
            for(cell in row) {
                builder.append(cell)
                builder.append('|')
            }
            builder.append('\n')
        }
        return builder.toString()
    }
}
