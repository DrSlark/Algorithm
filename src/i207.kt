import java.util.*

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    if (numCourses != prerequisites.size) {
        return false
    }
    var numCoursesC = numCourses
    val inDegrees = Array<Int>(0) { 0 }
    prerequisites.forEach {
        inDegrees[it[0]]++
    }
    val queue = FixedArrayQueue(100)
    inDegrees.forEachIndexed { index, i ->
        if (i == 0) {
            queue.offer(index)
        }
    }

    while (queue.size() != 0) {
        val pre = queue.poll()
        numCoursesC--
        prerequisites.forEach {
            if (it[1] == pre) {
                inDegrees[it[0]]--
                if (inDegrees[it[0]] == 0) {
                    queue.offer(it[0])
                }
            }
        }

    }
    return numCoursesC == 0


}