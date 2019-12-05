class StringIterator(val compressedString: String) {

    var currentIndex: Int = 0
    var lastValidChar: Char
    var count = 0

    init {
        lastValidChar = if (compressedString.isEmpty()) {
            0.toChar()
        } else {
            compressedString[0]
        }
    }

    fun next(): Char {
        if (!hasNext()) {
            return ' '
        }

        if (count == 0) {
            lastValidChar = compressedString[currentIndex]
            currentIndex++
            while (currentIndex < compressedString.length && compressedString[currentIndex] in '0'..'9') {
                count = count * 10 + (compressedString[currentIndex++] - '0')
            }
        }
        count--
        return lastValidChar

    }

    fun hasNext(): Boolean {
        return !(currentIndex == compressedString.length && count == 0)

    }

}

fun main() {
//    val it = StringIterator("L10e2t1C1o1d1e1")
    val it = StringIterator("L1e1")
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())
    println(it.next())

}