package kakuro

val BLANK:Cell = VCell(0)

class VCell(var v:Int):Cell {
    override fun toString():String {
        return if(v == 0)
            "     "
        else
            "%5s".format(v)
    }
}
