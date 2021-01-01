package br.dev.edsonpatricio.kfrdm.listings

interface Account {
    companion object {
        fun apply(/* parameters*/) {
            // instantiate Checking, Saving or MoneyMarket account
            // depending on parameters
        }
    }
}

data class CheckingAccount(val name: String /* other parameters */): Account
data class SavingsAccount(val name: String /* other parameters */): Account
data class MoneyMarketAccount(val name: String /* other parameters */): Account

