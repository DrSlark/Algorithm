fun editLength(s0: String, s1: String): Int {
    val m = s1.length
    val n = s0.length
    if (n * m == 0) {
        return m + n
    }
    val distance = Array(m + 1) {
        Array(n + 1) { 0 }
    }
    for (i in 0 until n + 1) {
        distance[i][0] = i
    }
    for (i in 0 until m + 1) {
        distance[0][i] = i
    }


    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            val a = distance[i - 1][j]
            val b = distance[i][j - 1]
            val c = distance[i][j] + if (s0[i] == s1[j]) {
                1
            } else {
                0
            }

        }
    }
    return 1
}


fun main() {

}