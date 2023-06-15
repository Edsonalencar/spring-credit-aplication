package com.alencar.springcreditaplication.domain.credit

import com.alencar.springcreditaplication.domain.credit.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
}