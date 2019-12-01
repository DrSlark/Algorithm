fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    if (x in 0 until 10) {
        return true
    }
    if (x % 10 == 0) {
        return false
    }
    var rx = x
    var px = 0
    while (rx > px) {
        px = px * 10 + rx % 10
        rx /= 10
    }
    return rx == px || px / 10 == rx

}

fun main() {
    println(isPalindrome(10))
    println(isPalindrome(100))
    println(isPalindrome(121))
    println(isPalindrome(1221))
    println(isPalindrome(12321))
    println(isPalindrome(123211))
}