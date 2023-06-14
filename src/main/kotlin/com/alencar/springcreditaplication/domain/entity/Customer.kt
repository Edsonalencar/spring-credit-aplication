package com.alencar.demo.entity

import jakarta.persistence.*

import java.math.BigDecimal

@Entity
@Table(name = "Client")
data class Customer(
    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var lastName: String = "",
    @Column(nullable = false, unique = true)
    val cpf: String,
    @Column(nullable = false, unique = true)
    var email: String = "",
    @Column(nullable = false)
    var password: String = "",
    @Column(nullable = false)
    @Embedded
    val  address: Address =  Address(),
    @Column(nullable = false)
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = arrayOf(CascadeType.REMOVE),
        mappedBy = "customer"
    )
    val credits: List<Credit> = mutableListOf(),
    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
