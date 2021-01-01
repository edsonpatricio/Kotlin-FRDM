package br.dev.edsonpatricio.kfrdm.listings

import java.lang.Exception
import java.math.BigDecimal

//typealias Amount = BigDecimal // Intellij bug prevents us from doing it

//data class Balance(val amount: Amount = Amount(0)) // Intellij bug prevents us from doing it
data class Balance(val amount: BigDecimal = BigDecimal(0))

class Account(
    val no: String,
    val name: String,
    val balance: Balance = Balance(BigDecimal(0))
) {

    fun debit(a: BigDecimal): Account {
        if (balance.amount < a) {
            throw Exception("Insufficient balance in account")
        }
        return Account(no, name, Balance(balance.amount - a))
    }

    fun credit(a: BigDecimal): Account {
        return Account(no, name, Balance(balance.amount + a))
    }
}

val a = Account("a1", "John")
a.balance == Balance(BigDecimal(0))

val b = a.credit(BigDecimal(100))
a.balance == Balance(BigDecimal(0))
b.balance == Balance(BigDecimal(100))

val c = b.debit(BigDecimal(20))
b.balance == Balance(BigDecimal(100))
c.balance == Balance((BigDecimal(80)))
