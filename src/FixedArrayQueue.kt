class FixedArrayQueue(
    val fixedSize: Int
) {
    var count: Int = 0
    var head: Int = 0
    var tail: Int = 0

    var headArray: ArrayList<Any>
    var tailArray: ArrayList<Any>

    init {
        headArray = ArrayList<Any>()
        tailArray = headArray
    }

    fun offer(num: Int) {
        if (tail == fixedSize - 1) {
            val list = ArrayList<Any>()
            list.add(num)
            tailArray.add(list)
            tailArray = tailArray[tail] as ArrayList<Any>
            tail = 1
            count++
            return
        }
        count++
        tail++
        tailArray.add(num)
    }

    fun poll(): Int? {
        if (count == 0) {
            return null
        }
        if (head == fixedSize - 1) {
            val newHeadArray = headArray[head] as ArrayList<Any>
            headArray.clear()
            headArray = newHeadArray
            head = 1
            count--
            return headArray[0] as Int
        }

        count--
        val r = headArray[head] as Int
        head++
        return r
    }

    fun size(): Int {
        return count
    }


}

fun main() {
    val q = FixedArrayQueue(3)
    for (i in 0 until 10) {
        q.offer(i)
    }
    for (i in 0 until 10) {
        println(q.poll())
    }

}