package com.alencar.springcreditaplication.domain.customer

interface ICustomerServiceInterface {
    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun findAll(): List<Customer>

    fun delete(id: Long)
}