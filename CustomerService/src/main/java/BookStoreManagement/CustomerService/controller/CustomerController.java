package BookStoreManagement.CustomerService.controller;


import BookStoreManagement.CustomerService.convertor.Convertor;
import BookStoreManagement.CustomerService.dto.CustomerDto;
import BookStoreManagement.CustomerService.model.Customer;
import BookStoreManagement.CustomerService.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final Convertor convertor;


    public CustomerController(CustomerService customerService, Convertor convertor) {
        this.customerService = customerService;
        this.convertor = convertor;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getallCustomer());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId){
        Customer customer = customerService.getCustomerById(customerId);
        var dto = convertor.toDto(customer);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        Customer customer = convertor.toEntity(customerDto);
        customerService.addCustomer(customer);
        var dto = convertor.toDto(customer);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer Deleted Successfully");
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long customerId, @Valid @RequestBody CustomerDto customerDto){

        Customer customer = customerService.getCustomerById(customerId);
        customer.setCustomerName(customerDto.customerName());
        customer.setPhone(customerDto.phone());
        customer.setEmail(customerDto.email());
        customerService.updateCustomer(customerId,customer);
        var dto = convertor.toDto(customer);
        return ResponseEntity.ok(dto);
    }






}
