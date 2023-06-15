package com.alencar.springcreditaplication.aplication.credit

import com.alencar.springcreditaplication.domain.credit.Credit
import com.alencar.springcreditaplication.domain.credit.CreditRepository
import com.alencar.springcreditaplication.domain.credit.ICreditServiceInterface
import com.alencar.springcreditaplication.domain.customer.CustomerRepository
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository,
    private val customerRepository: CustomerRepository
) : ICreditServiceInterface {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerRepository.findById(credit.customer?.id!!).get()
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)

        if (credit.customer?.id != customerId) throw RuntimeException("Credit not found")
        else return credit
    }
}