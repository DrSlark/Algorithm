fun max(a: Int, b: Int) = if (a > b) {
    a
} else {
    b
}

fun rob(nums: IntArray): Int {
    if (nums.size == 0) {
        return 0
    }
    if (nums.size == 1) {
        return nums[0]
    }
    if (nums.size == 2) {
        return max(nums[0], nums[1])
    }
    val s = IntArray(nums.size)
    s[0] = nums[0]
    s[1] = nums[1]
    for (i in 2 until nums.size) {
        var max = 0
        for (j in 0 until i - 1) {
            max = max(nums[i] + s[j], max)
        }
        s[i] = max(max, s[i - 1])

    }

    return s[nums.size - 1]
}