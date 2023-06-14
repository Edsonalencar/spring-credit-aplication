package com.alencar.demo.entity

import com.alencar.demo.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Credit")
data class Credit(
    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    var creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    var dayFirstInstallment: LocalDate,
    @Column(nullable = false)
    var numberOfInstallments: Int = 0,
    @Enumerated
    var status: Status = Status.IN_PROGRESS,
    @ManyToOne()
    val customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
