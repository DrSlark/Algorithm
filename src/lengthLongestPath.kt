//fun ll(input: String, level: Int): Int {
//    if (!input.contains("\n\t")) {
//        return input.length
//    }
//    val needSeg = StringBuilder("\n\t").apply {
//        for (i in 0 until level) {
//            append("\t")
//        }
//        toString()
//    }
//
//    val startState = 0
//    val filenameState = 1
//    val tagState = 2
//
//
//    var foundlevel = 0
//    var filenameSb = StringBuilder()
//    var state = startState
//    input.forEachIndexed { index, char ->
//        if (char == '\n') {
//            state = tagState
//        }
//
//        if (char == '\t') {
//            foundlevel++
//        }
//
//
//
//        when (state) {
//            startState -> {
//            }
//            filenameState -> {
//            }
//            tagState -> {
//
//            }
//        }
//
//
//    }
//
//
//}
//
//fun lengthLongestPath(input: String): Int {
//    val startState = 0
//    val filenameState = 1
//    val tagState = 2
//
//    val maxPath = StringBuilder()
//
//    var filenameSb = StringBuilder()
//    var state = startState
//    input.forEach { char ->
//
//        if (char == '\n') {
//            state = tagState
//        }
//
//        if (char == '\t') {
//
//        }
//
//
//
//        when (state) {
//            startState -> {
//            }
//            filenameState -> {
//            }
//            tagState -> {
//
//            }
//        }
//
//
//    }
//
//
//    return 0
//
//}