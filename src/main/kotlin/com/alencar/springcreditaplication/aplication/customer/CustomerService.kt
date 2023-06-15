package com.alencar.springcreditaplication.aplication.customer

import com.alencar.springcreditaplication.domain.customer.Customer
import com.alencar.springcreditaplication.domain.customer.CustomerRepository
import com.alencar.springcreditaplication.domain.customer.ICustomerServiceInterface
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerServiceInterface {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("id $id not found")
        }
    }

    override fun findAll(): List<Customer> {
        return this.customerRepository.findAll()
    }

    override fun delete(id: Long) {
        return  this.customerRepository.deleteById(id)
    }

}