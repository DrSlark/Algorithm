class LRUCache(private val capacity: Int) {
    private class Node(val key: Int? = null, var value: Int? = null, var pre: Node? = null, var next: Node? = null)


    private var size = 0
    private val head: Node
    private val tail: Node

    init {
        head = Node()
        tail = Node()
        head.next = tail
        tail.pre = head
    }

    private fun findNode(key: Int): Node? {
        var p = head.next
        while (p !== tail) {
            if (p?.key == key) {
                return p
            }
            p = p?.next
        }
        return null
    }

    private fun rmTail() {
        if (tail.pre?.pre == null) {
            return
        }
        val prepreNode = tail.pre?.pre
        prepreNode?.next = tail
        tail.pre = prepreNode
    }

    private fun addToHead(node: Node) {
        node.next = head.next
        node.pre = head
        head.next?.pre = node
        head.next = node
    }

    private fun rmNode(node: Node) {
        node.pre?.next = node.next
        node.next?.pre = node.pre
        node.next = null
        node.pre = null
    }

    private fun moveToFirst(node: Node) {
        rmNode(node)
        addToHead(node)
    }

    fun get(key: Int): Int {
        val node = findNode(key) ?: return -1
        moveToFirst(node)
        return node.key ?: -1
    }

    fun put(key: Int, value: Int) {
        findNode(key)?.let {
            it.value = value
            moveToFirst(it)
        } ?: kotlin.run {
            addToHead(Node(key, value))
            size++
            if (size > capacity) {
                rmTail()
                size = capacity
            }
        }

    }

    fun print() {
        var n = head.next

        print("${size}")
        while (n !== tail) {
            print("[${n?.key} ${n?.value}] ")
            n = n!!.next
        }
        println()
    }

}

//["LRUCache","put","put","put","get","put","put","get","put","put","get","put","get","get","get","put","put","get","put","get"]
//[[10],[7,28],[7,1],[8,15],[6],[10,27],[8,10],[8],[6,29],[1,9],[6],[10,7],[1],[2],[13],[8,30],[1,5],[1],[13,2],[12]]
fun main() {
    val l = LRUCache(10)
    l.put(7, 28)
    l.put(7, 1)
    l.put(8, 15)
    println(l.get(6))
    l.put(10, 27)
    l.put(8, 10)
    println(l.get(8))
//    l.put(6, 29)
//    l.put(1, 29)
//    println(l.get(6))
//    l.put(10, 7)
//    println(l.get(1))
//    println(l.get(2))
//    println(l.get(13))
}