data class Node(
    val value: Int,
    var next: Node? = null
)

fun reverseNode(rawHead: Node?): Node? {
    var p = rawHead
    var h = rawHead
    while (p != null) {
        var pn = p.next
        p.next = h
        h = p
        p = pn
    }
    rawHead?.next = null

    return h
}

fun reverseNode1(rawHead: Node?): Node? {
    var p = rawHead
    var h : Node? = null
    while (p != null) {
        var pn = p.next
        p.next = h
        h = p
        p = pn
    }


    return h
}


fun printLink(head: Node?) {
    var p: Node? = head
    while (p != null) {
        print("${p.value} ")
        p = p.next
    }
    println()
}

fun main() {
    val head = Node(0)
    var p: Node? = head
    for (i in 0 until 10) {
        p?.next = Node((i + 1))
        p = p?.next
    }
    printLink(head)
    val rHead = reverseNode1(head)
    printLink(rHead)

}