import java.math.BigDecimal
import java.util.*

println("Hello")

typealias Amount = BigDecimal

data class Balance(val amount: Amount = Amount(0))

class Account(
    val no: String,
    val name: String,
    val dateOfOpening: Date,
    val balance: Balance = Balance()
) {
    fun debit(amount: Amount): Account {
        if (balance.amount < amount) {
            throw Exception("Insufficient balance in account")
        }
        return Account(no, name, dateOfOpening, Balance(balance.amount - amount))
    }

    fun credit(amount: Amount): Account {
        return Account(no, name, dateOfOpening, Balance(balance.amount + amount))
    }
}

val a = Account("a1", "John", Date())
a.balance == Balance(Amount(0))

val b = a.credit(Amount(100))
a.balance == Balance(Amount(0))
b.balance == Balance(Amount(0))

val c = b.debit(Amount(0))
b.balance == Balance(Amount(100))
c.balance == Balance(Amount(80))