import java.util.*
import kotlin.collections.HashMap

fun twoSum(nums :IntArray, target:Int):IntArray{
    val map = nums.foldIndexed(HashMap<Int, Int>()){ index, acc, i ->
        acc[i] = index
        acc
    }
    val result = IntArray(2)
    for(i in 0 until nums.size) {
        val need = target - nums[i]
        val searched = map[need]
        if(searched != null && searched!=i ) {
            result[0] = searched
            result[1] = i
            break
        }
    }
    return result

}
fun main() {



}