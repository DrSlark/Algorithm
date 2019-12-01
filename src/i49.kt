fun doPermute(startIndex: Int, nums: IntArray): List<List<Int>> {
    if (startIndex == nums.size - 1) {
        return listOf(nums.toList())
    }
    val result = ArrayList<List<Int>>()
    for (i in startIndex until nums.size) {
        var tmp = nums[i]
        nums[i] = nums[startIndex]
        nums[startIndex] = tmp
        doPermute(startIndex + 1, nums).forEach{
            result.add(it)
        }
        var tmp1 = nums[i]
        nums[i] = nums[startIndex]
        nums[startIndex] = tmp1
    }
    return result
}

fun permute(nums: IntArray): List<List<Int>> {
   return doPermute(0, nums)
}

fun main() {
    permute(IntArray(4){ i -> i }).forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}
