package kakuro

val NA:Cell = QCell(0, 0)

class QCell(val h:Int, val v:Int):Cell {
    override fun toString():String {
        return if(h == 0 && v == 0) {
            "@@@@@"
        } else {
            "%2s".format(v) + "," + "%2s".format(h)
        }
    }
}
