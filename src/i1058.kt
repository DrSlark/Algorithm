fun minimizeError(prices: Array<String>, target: Int): String {
    var mutableTarget = target
    var decimalsArray = ArrayList<Int>()
    prices.forEach {
        val pointIndex = it.indexOf('.')
        mutableTarget -= it.substring(0, pointIndex).toInt()
        val decimalPart = it.substring(pointIndex + 1, it.length).toInt()
        if (decimalPart != 0) {
            decimalsArray.add(decimalPart)
        }
    }
    if (mutableTarget > decimalsArray.size) {
        return "-1"
    }
    if (mutableTarget < 0) {
        return "-1"
    }

    var roundPrice = 0
    decimalsArray.sort()
    for (i in decimalsArray.size - 1 downTo 0) {
        roundPrice += if (mutableTarget == 0) {
            decimalsArray[i]
        } else {
            mutableTarget -= 1
            1000 - decimalsArray[i]
        }

    }
    val formattedDecimal = when (roundPrice % 1000) {
        in 0 until 10 -> {
            "00${roundPrice % 1000}"
        }
        in 10 until 100 -> {
            "0${roundPrice % 1000}"
        }
        else -> {
            "${roundPrice % 1000}"
        }
    }

    return "${roundPrice / 1000}.$formattedDecimal"
}

fun main() {
    println(minimizeError(arrayOf("0.700", "2.800", "4.900"), 8))
}