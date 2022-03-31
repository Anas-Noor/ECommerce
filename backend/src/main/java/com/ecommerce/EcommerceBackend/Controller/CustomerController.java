package com.ecommerce.EcommerceBackend.Controller;

import com.ecommerce.EcommerceBackend.Dto.CustomerDto;
import com.ecommerce.EcommerceBackend.Model.Customer;
import com.ecommerce.EcommerceBackend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }
    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id,@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id,customerDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}