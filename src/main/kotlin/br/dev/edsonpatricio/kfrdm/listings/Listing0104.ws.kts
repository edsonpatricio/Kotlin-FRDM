package br.dev.edsonpatricio.kfrdm.listings

import java.lang.Exception
import java.math.BigDecimal
import java.util.*

//typealias Amount = BigDecimal // Intellij bug prevents us from doing it

//data class Balance(val amount: Amount = Amount(0)) // Intellij bug prevents us from doing it
data class Balance(val amount: BigDecimal = BigDecimal(0))

class Account(
    val no: String,
    val name: String,
) {
    var balance: Balance = Balance(BigDecimal(0))

    fun debit(a: BigDecimal): Balance {
        if (balance.amount < a) {
            throw Exception("Insufficient balance in account")
        }
        balance = Balance(balance.amount - a)
        return balance
    }

    fun credit(a: BigDecimal): Balance {
        balance = Balance(balance.amount + a)
        return balance
    }
}

val a = Account("a1", "John")
a.balance == Balance(BigDecimal(0))

a.credit(BigDecimal(100))
a.balance == Balance(BigDecimal(100))

a.debit(BigDecimal(20))
a.balance == Balance(BigDecimal(80))