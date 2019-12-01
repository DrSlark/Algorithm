fun findLPS(s: String) {
    val m = Array(s.length) { BooleanArray(s.length) }

    var maxi = 0
    var maxj = 0
    var nowMaxLen = 1
    for (j in 0 until s.length) {
        m[j][j] = true
        for (i in 0 until j) {
            m[i][j] = s[i] == s[j] && (j - i <= 1 || m[i + 1][j - 1])
            if (m[i][j]) {
                if (nowMaxLen < j - i + 1) {
                    nowMaxLen = j - i + 1
                    maxi = i
                    maxj = j
                }
            }
        }
    }
    println( s.substring(maxi, maxj + 1))
}


fun main() {
    findLPS("aba")
    findLPS("abdeedbaaba")
    findLPS("abcdefg")

}