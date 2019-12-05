import kotlin.math.min

fun coinChange(coins: IntArray, amount: Int, memMap: HashMap<Int, Int>): Int {
    if (amount == 0) {
        return 0
    }
    var min = Int.MAX_VALUE
    coins.filter {
        it <= amount
    }.forEach {
        val sub = memMap[amount - it] ?: coinChange(coins, amount - it, memMap)
        if (sub == -1) {
            memMap[amount - it] = -1
            return@forEach
        }

        min = min(min, sub + 1)
        memMap[amount] = min
    }

    return if (min == Int.MAX_VALUE) {
        -1
    } else {
        min
    }

}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11, HashMap<Int, Int>()))
}