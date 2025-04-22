package com.example.backend.repository;

import com.example.backend.model.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindAll() {
        // Create a new Customer
        Customer customer = new Customer();
        customer.setStoreID(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");
        customer.setAddress("123 Main St");
        customer.setActive(true);
        customer.setCreationDate(LocalDateTime.now());
        customer.setLastUpdated(LocalDateTime.now());

        // Save the customer
        customerRepository.save(customer);

        // Retrieve all customers
        List<Customer> customers = customerRepository.findAll();

        // Assert that the list is not empty and contains the expected data
        assertThat(customers).isNotEmpty();
        assertThat(customers.get(0).getFirstName()).isEqualTo("John");
    }
}
