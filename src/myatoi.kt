fun myAtoi(str: String): Int {
    val stateStart = 1
    val stateNumber = 2
    var state = stateStart
    var sum = 0
    var isNeg = false

    str.forEachIndexed { index: Int, c: Char ->
        if (c == ' ') {
            if (state == stateStart) {
                return@forEachIndexed
            } else if (state == stateNumber) {
                return sum
            }
        }

        if (c == '-') {
            if (state == stateStart) {
                isNeg = true
                state = stateNumber
                return@forEachIndexed
            } else {
                return sum
            }
        }

        if (c == '+') {
            if (state == stateStart) {
                isNeg = false
                state = stateNumber
                return@forEachIndexed
            } else {
                return sum
            }
        }

        if (c in '0'..'9') {
            if (state == stateStart || state == stateNumber) {
                state = stateNumber
                if (isNeg) {
                    if (sum < Int.MIN_VALUE / 10) {
                        return Int.MIN_VALUE
                    }
                    sum = sum * 10 - (c - '0')
                    if (sum > 0) {
                        return Int.MIN_VALUE
                    }
                } else {
                    if (sum > Int.MAX_VALUE / 10) {
                        return Int.MAX_VALUE
                    }
                    sum = sum * 10 + (c - '0')
                    if (sum < 0) {
                        return Int.MAX_VALUE
                    }
                }

                return@forEachIndexed
            }
        }

        if (c !in '0'..'9') {
            return sum
        }
    }

    return sum

}

fun main() {
    println(myAtoi("2147483648"))
    println(myAtoi("0-1"))
//    println(myAtoi("-123"))
//    println(myAtoi("+123"))
//    println(myAtoi("-123-"))
//    println(myAtoi("-123 im abc"))
//    println(myAtoi("-91283472332"))

}