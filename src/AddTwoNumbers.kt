data class ListNode(
    val `val`: Int,
    var next: ListNode? = null
)

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    var hl3: ListNode? = null
    var pl3: ListNode? = null
    var c = false
    while (p1 != null && p2 != null) {
        val r = p1.`val` + p2.`val` + if (c) {
            1
        } else {
            0
        }
        p1 = p1.next
        p2 = p2.next
        c = r - 10 >= 0
        val v = if (r - 10 >= 0) {
            r - 10
        } else {
            r
        }
        val t = ListNode(v)
        if (pl3 != null) {
            pl3.next = t
            println("00000")
        }
        pl3 = t

        if (hl3 == null) {
            hl3 = t
        }
        println("11111")

    }
    while (p1 != null) {
        val r = p1.`val`  + if (c) {
            1
        } else {
            0
        }
        p1 = p1.next
        c = r - 10 >= 0
        val v = if (r - 10 >= 0) {
            r - 10
        } else {
            r
        }
        val t = ListNode(v)
        if (pl3 != null) {
            pl3.next = t
        }
        pl3 = t

        if (hl3 == null) {
            hl3 = t
        }
        println("22222")


    }
    while (p2 != null) {
        val r = p2.`val`  + if (c) {
            1
        } else {
            0
        }
        p2 = p2.next
        c = r - 10 >= 0
        val v = if (r - 10 >= 0) {
            r - 10
        } else {
            r
        }
        val t = ListNode(v)
        if (pl3 != null) {
            pl3.next = t
        }
        pl3 = t

        if (hl3 == null) {
            hl3 = t
        }
        println("33333")
    }
    if(c) {
        pl3?.next = ListNode(1)
    }

    return hl3
}

fun printLink(head: ListNode?) {
    var p: ListNode? = head
    while (p != null) {
        print("${p.`val`} ")
        p = p.next
    }
    println()
}

fun main() {
//    val l1 = ListNode(9)
//    l1.next = ListNode(9)
//    l1.next?.next =ListNode(9)
//
//    val l2 = ListNode(9)
//    l2.next = ListNode(9)
//    l2.next?.next =ListNode(9)


    val l1 = ListNode(0)
    val l2 = ListNode(0)
    printLink(addTwoNumbers(l1, l2))

}