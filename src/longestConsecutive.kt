fun longestConsecutive(root: TreeNode?): Int {


    return dfs(root, null, 1)

}

fun dfs(node: TreeNode?, nodeParent: TreeNode?, maxLength: Int): Int {
    if (node == null) {
        return maxLength
    }
    val length = if (nodeParent != null && nodeParent.`val` - node.`val` == 1) {
        maxLength + 1
    } else {
        1
    }
    val maxFunc = { a: Int, b: Int ->
        if (a >= b) {
            a
        } else {
            b
        }

    }
    return maxFunc(length, maxFunc(dfs(node.left, node, length), dfs(node.right, node, length)))

}