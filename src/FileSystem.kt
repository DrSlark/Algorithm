class FileSystem {
    data class Node(val name: String, val `val`: Int, val child: ArrayList<Node> = ArrayList())

    private val rootNode = Node("", -1)

    fun findPath(pathArray: List<String>, endIndex: Int = pathArray.size): Node? {
        var searchNode: Node? = rootNode
        for (i in 0 until endIndex) {
            searchNode = searchNode?.child?.find { it.name == pathArray[i] }
            if (searchNode == null) {
                return null
            }
        }
        return searchNode
    }

    companion object {
        fun pathStr2pathArray(path: String): List<String> {
            val list = ArrayList<String>()
            val pathSegment = StringBuilder()
            var isInSeg = false
            for (char in path) {
                if (char == '/') {
                    if (isInSeg) {
                        list.add(pathSegment.toString())
                        pathSegment.clear()
                    } else {
                        isInSeg = true
                    }
                } else {
                    pathSegment.append(char)
                }
            }
            list.add(pathSegment.toString())

            return list
        }
    }


    fun createPath(path: String, value: Int): Boolean {
        val pathArray = pathStr2pathArray(path)
        if (pathArray.size == 0) {
            return false
        }
        if (findPath(pathArray) != null) {
            return false
        }
        if (pathArray.size == 1) {
            val node = rootNode.child.find { it.name == pathArray[0] }
            if (node != null) {
                return false
            } else {
                rootNode.child.add(Node(pathArray[0], value))
            }
        } else {
            val parentNode = findPath(pathArray, pathArray.size - 1) ?: return false
            parentNode.child.add(Node(pathArray.last(), value))
        }

        return true
    }

    operator fun get(path: String) = findPath(pathStr2pathArray(path))?.`val` ?: -1
}

fun main() {
    val fileSystem = FileSystem()
    fileSystem.createPath("/a", 1).also { println(it) }
    fileSystem.createPath("/a/b", 2).also { println(it) }
    fileSystem.createPath("/c/b", 2).also { println(it) }
//    fileSystem.get("/a").also { println(it) }
    fileSystem.get("/a/b").also { println(it) }


}
