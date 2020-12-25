package br.dev.edsonpatricio.kfrdm.ch01.listings

import br.dev.edsonpatricio.kfrdm.mocks.Address
import br.dev.edsonpatricio.kfrdm.mocks.Amount
import br.dev.edsonpatricio.kfrdm.mocks.Bank
import java.math.BigDecimal
import java.util.*

interface Account {
    val no: String
    val name: String
    val bank: Bank
    val address: Address
    val dateOfOpening: Date
    val dateOfClose: Date?
    //...
}

data class CheckingAccount(
    override val no: String,
    override val name: String,
    override val bank: Bank,
    override val address: Address,
    override val dateOfOpening: Date,
    override val dateOfClose: Date?
) : Account


data class SavingAccount(
    override val no: String,
    override val name: String,
    override val bank: Bank,
    override val address: Address,
    override val dateOfOpening: Date,
    override val dateOfClose: Date?,
    val rateOfInterest: BigDecimal
) : Account

interface AccountService {
    fun transfer(
        from: Account,
        to: Account,
        amount: Amount
    ): Amount?
}