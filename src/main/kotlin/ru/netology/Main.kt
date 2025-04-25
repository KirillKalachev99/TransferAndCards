
package ru.netology

const val MASTERCARD_MONTHLY_NO_RATE = 75_000
const val MASTERCARD_RATE = 0.006
const val MASTERCARD_ADD_SUM = 20
const val VISA_RATE = 0.0075
const val VISA_MIN_COM = 35
const val MONTHLY_LIMIT = 600_000
const val DAILY_LIMIT = 150_000
val CARD_TYPE_POOL = arrayOf("Mastercard", "Visa", "МИР")

fun main() {
    val monthlySumMain = 0
    println("Выберите карту, с которой производите перевод:")
    for (i in 0..2) {
        println("${i.plus(1)}. ${CARD_TYPE_POOL[i]}")
    }
    val cardTypeInput = readln().toInt() - 1
    print("Введите сумму перевода: ")
    val transferInput = readln().toInt()

    comissionCount(CARD_TYPE_POOL[cardTypeInput], monthlySumMain, transferInput)
}


fun comissionCount(cardType: String = CARD_TYPE_POOL[2], monthlySum: Int, transferSum: Int) : Int{
    if (transferSum > DAILY_LIMIT) {
        println("Сумма перевода не может быть больше дневного лимита на переводы в $DAILY_LIMIT руб.")
    }

    val dailySum = 0
    val monthlySumReal = monthlySum + transferSum
    val dailySumReal = dailySum + transferSum
    val mastercardSumAfterLimit = ((transferSum - MASTERCARD_MONTHLY_NO_RATE) * MASTERCARD_RATE).toInt() + MASTERCARD_ADD_SUM
    var comission = 0

    if (monthlySumReal > MONTHLY_LIMIT || dailySumReal > DAILY_LIMIT) {
        println("Лимиты превышены")
    }
    else {
        val masterCardCom = (transferSum * MASTERCARD_RATE).toInt() + MASTERCARD_ADD_SUM
        val visaCardCom = (transferSum * VISA_RATE).toInt()

        comission = when (cardType) {
            CARD_TYPE_POOL[0] ->
                if (transferSum > MASTERCARD_MONTHLY_NO_RATE) mastercardSumAfterLimit
                else if (monthlySum < MASTERCARD_MONTHLY_NO_RATE) 0
                else masterCardCom

            CARD_TYPE_POOL[1] ->
                if (visaCardCom > VISA_MIN_COM) visaCardCom
                else VISA_MIN_COM

            else -> 0
        }
    }
    print("Комиссия по переводу составит: $comission руб.")
    return comission
}
