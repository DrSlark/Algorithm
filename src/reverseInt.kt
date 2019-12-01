// abdcdcdslkwq

fun reverseInt(x: Int): Int {
    var px = x
    var revertX = 0
    while (px != 0) {
        if (revertX > Int.MAX_VALUE / 10) {
            return 0
        }
        if(revertX < Int.MIN_VALUE / 10) {
            return 0
        }
        val rr = revertX * 10 + px % 10
        revertX = rr
        px /= 10
    }
    return revertX
}

fun main() {

    println(reverseInt(-15346469))
}