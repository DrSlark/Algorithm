fun rotate(matrix: Array<IntArray>) {
    val columnSize = matrix[0].size
    val rowSize = matrix.size
    for (i in 0 until rowSize/2) {
        for (j in 0 until columnSize/2) {
            val t = matrix[i][j]
            matrix[i][j] = matrix[j][columnSize - 1 - i]
            matrix[j][columnSize - 1 - i] = t
        }
    }

}

fun main() {

}