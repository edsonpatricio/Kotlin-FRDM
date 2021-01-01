package br.dev.edsonpatricio.kfrdm.listings

interface AccountRepository {
    fun query(accountNo: String): Account?
    fun query(criteria: Criteria<Account>): List<Account>
    fun write(accounts: List<Account>): Boolean
    fun delete(account: Account): Boolean
}

// #################################################################################
interface Account
interface Criteria<T>