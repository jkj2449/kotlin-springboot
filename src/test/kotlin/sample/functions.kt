package sample

fun myFun(p: () -> Unit) = p()

fun takePrintNameFunction(name: String, pnFun: (String) -> Unit) {
    val local: (String) -> Unit = pnFun
    local(name)
}

fun supplyPrintNameFunction(): (String) -> Unit {
    return { name: String ->
        println("your name is '$name'!")
    }
}

fun main(args: Array<String>) {
    myFun {
        println("Hello Kotlin FP!")
    }

    val printName = fun(name: String) {
        println("your name is '$name'")
    }

    printName("anna")
    printName("john")

    val pName2: (String) -> Unit = printName
    pName2("ellsa")

    val pName3 = { name: String ->
        println("your name is '$name'!")
    }
    pName3("lee")

    takePrintNameFunction("david", pName3)
    takePrintNameFunction("david", fun(n: String) {
        println("your name is '$n'!")
    })
    takePrintNameFunction("david", { x: String -> println("your name is '$x'!") })

    takePrintNameFunction("Yan", supplyPrintNameFunction())

    val pName4: (String) -> Unit = supplyPrintNameFunction()
    pName4("Park")

    supplyPrintNameFunction()("Kim")

    listOf<Int>(1,2,3,4,5,6,7).showNumbersToString({n -> n % 2 == 1}, concats)
    (1..7).toList().showNumbersToString(fun(n: Int) = n % 2 == 0, concats)
}

fun List<Int>.showNumbersToString(pre: (Int) -> Boolean, con: (List<Int>, String) -> String) {
    val list: ArrayList<Int> = arrayListOf<Int>()
    for (n in list) {
        if (pre(n)) {
            list.add(n)
        }
    }
    println( con(this, ", ") )
}

val concats = fun(ints: List<Int>, sep: String): String {
    var s = ""
    for( (i, n) in ints.withIndex() ) {
        if(i < ints.lastIndex) s += "$n$sep"
        else s += n
    }

    return s
}