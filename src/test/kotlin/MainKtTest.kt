import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun comissionCount() {
        val cardType = "МИР"
        val cardType1 = "Visa"
        val cardType2 = "Mastercard"
        val monthlySum = 20_000
        val monthlySum1 = 100_000
        val monthlySum2 = 550_000


        val transferSum = 100_000
        val transferSum1 = 120_000
        val transferSum2 = 10_000
        val transferSum3 = 1_000
        val transferSum4 = 151_000



        val result = ru.netology.comissionCount(cardType, monthlySum, transferSum)
        val result1 = ru.netology.comissionCount(cardType1, monthlySum, transferSum1)
        val result2 = ru.netology.comissionCount(cardType2, monthlySum, transferSum2)
        val result4 = ru.netology.comissionCount(cardType, monthlySum1, transferSum)
        val result6 = ru.netology.comissionCount(cardType2, monthlySum1, transferSum2)
        val result7 = ru.netology.comissionCount(cardType1, monthlySum, transferSum3)
        val result8 = ru.netology.comissionCount(cardType, monthlySum, transferSum4)
        val result9 = ru.netology.comissionCount(cardType2, monthlySum2, transferSum1)




        assertEquals(0, result)
        assertEquals(900, result1)
        assertEquals(0, result2)
        assertEquals(0, result4)
        assertEquals(80, result6)
        assertEquals(35, result7)
        assertEquals(35, result8)
        assertEquals(35, result9)

    }
}

