fun quickSort(nums: Array<Int>, start: Int, end: Int) {

    if (start < end) {
        val i = partion(nums, start, end)
        quickSort(nums, start, i)
        quickSort(nums, i+1, end)
    }

}

fun partion(nums: Array<Int>, start: Int, end: Int): Int {
    var target = nums[start]
    var targetI = start
    var i = start
    var j = start
    while (i < end) {
        if (nums[i] >= target) {
            i++
            continue
        }
        if (nums[i] < target) {
            if (j == targetI) {
                targetI = i
            }
            val t = nums[j]
            nums[j] = nums[i]
            nums[i] = t
            i++
            j++
        }
    }
    if (nums[j] > target && j < targetI) {
        val t = nums[j]
        nums[j] = target
        nums[targetI] = t
    }
    println("${nums[j]} $j")
    printArrayInt(nums)
    return j


}

fun printArrayInt(nums: Array<Int>) {
    nums.forEach {
        print("$it ")
    }
    println()
}

fun main() {
    val t1 = arrayOf(188, 231, 546, 34, 2, 21, 43, 2543, 6547, 68, 99, 4, 213, 23, 3, 1, 123, 3, 532, 64, 4, 188)
    quickSort(t1, 0, t1.size)
    printArrayInt(t1)
}