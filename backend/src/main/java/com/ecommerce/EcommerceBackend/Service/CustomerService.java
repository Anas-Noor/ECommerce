package com.ecommerce.EcommerceBackend.Service;


import com.ecommerce.EcommerceBackend.Dto.CustomerDto;
import com.ecommerce.EcommerceBackend.Model.Customer;
import com.ecommerce.EcommerceBackend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void addCustomer(CustomerDto  customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setBillingAddress(customerDto.getBillingAddress());
        customer.setCountry(customerDto.getCountry());
        customer.setDefault_shipping_address(customer.getDefault_shipping_address());
        customer.setFullName(customerDto.getFullName());
        customer.setEmail(customer.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setPassword(customerDto.getPassword());
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
       return customerRepository.findAll();
    }
    public Customer findCustomerById(Long id) {
       return customerRepository.findById(id).orElseThrow(null);
    }

    public void updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        customer.setPassword(customerDto.getPassword());
        customer.setPhone(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        customer.setFullName(customerDto.getFullName());
        customer.setDefault_shipping_address(customerDto.getDefault_shipping_address());
        customer.setBillingAddress(customerDto.getBillingAddress());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        customerRepository.delete(customer);
    }
}
