fun pow(x: Int, n: Int): Int {
    if (n == 0) {
        return 1
    }
    if (n == 1) {
        return x
    }
    val half = pow(x, n / 2)
    return half * half * if (n % 2 == 0) {
        1
    } else {
        x
    }
}

fun solution(n: Int) {
    val columnSize = pow(2, n + 1)
    val rowSize = pow(2, n)
    val canvas = Array<Array<Char>>(rowSize) {
        Array(columnSize) {
            ' '
        }
    }

    draw(n, rowSize - 1, 0, canvas)

    canvas.forEach {
        it.forEach {
            print(it)
        }
        println()
    }
}


fun draw(n: Int, x: Int, y: Int, triAngCanvas: Array<Array<Char>>) {
    if (n == 1) {
        triAngCanvas[x][y] = '/'
        triAngCanvas[x][y + 1] = '_'
        triAngCanvas[x][y + 2] = '_'
        triAngCanvas[x][y + 3] = '\\'

        triAngCanvas[x - 1][y] = ' '
        triAngCanvas[x - 1][y + 1] = '/'
        triAngCanvas[x - 1][y + 2] = '\\'
        triAngCanvas[x - 1][y + 3] = ' '
        return
    }
    val columnSize = pow(2, n+1)
    val rowSize = pow(2, n)
    draw(n - 1, x, y, triAngCanvas)
    draw(n - 1, x, y + (columnSize) / 2, triAngCanvas)
    draw(n - 1, x- rowSize / 2, y + (columnSize) / 4, triAngCanvas)
}

fun main() {
    solution(6)
}