package com.example.challenge.Interfaces;

import com.example.challenge.DTO.CustomersDTO;
import com.example.challenge.Entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICustomers extends CrudRepository<Customer, String> {
    Customer findAllById(String id);

    Customer save(Customer customer);

    void deleteById(String id);
}
