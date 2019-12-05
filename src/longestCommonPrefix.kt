fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var maxPrefix = strs[0]
    strs.forEach { str ->
        if (maxPrefix.isEmpty()) {
            return ""
        }
        while (!str.startsWith(maxPrefix) && maxPrefix.isNotEmpty()) {
            maxPrefix = maxPrefix.substring(0, maxPrefix.length - 1)
        }
    }


    return maxPrefix

}