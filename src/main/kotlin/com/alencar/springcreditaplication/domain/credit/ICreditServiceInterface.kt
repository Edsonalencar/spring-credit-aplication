package com.alencar.springcreditaplication.domain.credit

import java.util.UUID

interface ICreditServiceInterface {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID):Credit
}