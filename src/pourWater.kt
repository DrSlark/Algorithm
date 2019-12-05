fun pourWater(heights: IntArray, V: Int, K: Int): IntArray {

    for (drop in 0 until V) {
        var lowestIndex = K
        var lowestHeight = heights[K]
        for (i in K - 1 downTo 0) {
            if (heights[i] < lowestHeight) {
                lowestHeight = heights[i]
                lowestIndex = i
                continue
            }
            if (heights[i] > lowestHeight) {
                break
            }
        }

        if (lowestIndex == K) {
            for (i in K + 1 until heights.size) {
                if (heights[i] < lowestHeight) {
                    lowestHeight = heights[i]
                    lowestIndex = i
                    continue
                }
                if (heights[i] > lowestHeight) {
                    break
                }
            }
        }

        heights[lowestIndex]++

    }


    return heights

}

fun main() {
    pourWater(intArrayOf(2, 1, 1, 2, 1, 2, 2), 4, 3).forEach {
        print("$it ")
    }
}