package com.housely.Controller;

import com.housely.Model.Customer.Customer;
import com.housely.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        try {
            return new ResponseEntity<>(customerService.findById(customerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        try {
            customerService.findById(customerId);
            customer.setId(customerId);
            return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteById(customerId);
            return new ResponseEntity<>("Customer Id:" + customerId + " was delete successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
