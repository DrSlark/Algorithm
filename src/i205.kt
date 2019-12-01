fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val charsArray = Array<Char>(128) {
        0.toChar()
    }

    for (i in 0 until s.length) {
        val index = charsArray.indexOfFirst { it == t[i] }
        if (index != -1 && s[i] != index.toChar()) {
            return false
        }
        if (charsArray[s[i].toInt()] == 0.toChar()) {
            charsArray[s[i].toInt()] = t[i]
            continue
        }
        if (charsArray[s[i].toInt()] != t[i]) {
            return false
        }

    }

    return true

}

fun main() {
    println(isIsomorphic("ab", "aa"))
    println(isIsomorphic("egge", "adda"))
    println(isIsomorphic("abb", "cdd"))
}