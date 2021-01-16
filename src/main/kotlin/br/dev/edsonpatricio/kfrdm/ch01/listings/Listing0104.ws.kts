import java.math.BigDecimal

typealias Amount = BigDecimal

data class Balance(val amount: Amount = Amount(0))

class Account(val no: String, val name: String) {
    var balance: Balance = Balance()

    fun debit(amount: Amount): Balance {
        if (balance.amount < amount) {
            throw Exception("Insufficient balance in account")
        } else {
            balance = Balance(balance.amount - amount)
        }
        return balance
    }

    fun credit(amount: Amount): Balance {
        balance = Balance(balance.amount + amount)
        return balance
    }
}

val a = Account("a1", "John")
a.balance == Balance(Amount(0))

a.credit(Amount(100))
a.balance == Balance(Amount(100))

a.debit(Amount(20))
a.balance == Balance(Amount(80))

print("Hi")