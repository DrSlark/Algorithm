fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var slowNode = head
    var quickNode = head
    var slowNodePre = head
    var i = 0
    while (quickNode != null) {
        quickNode = quickNode.next

        if (++i > n) {
            slowNodePre = slowNode
            slowNode = slowNode?.next
        }
    }
    if (slowNode == slowNodePre) {
        return head?.next
    }
    slowNodePre?.next = slowNode?.next

    return head

}


fun printListNodes(h: ListNode?) {
    var p: ListNode? = h
    while (p != null) {
        print("${p.`val`} ")
        p = p.next
    }
    println()
}

fun main() {
//    val h = ListNode(0)
//    var p: ListNode? = h
//    for (i in 1 until 3) {
//        p?.next = ListNode(i)
//        p = p?.next
//    }

    val h = ListNode(1)
        h.next = ListNode(2)
    printListNodes(removeNthFromEnd(h, 2))
}