package BookStoreManagement.CustomerService.service;

import BookStoreManagement.CustomerService.convertor.Convertor;
import BookStoreManagement.CustomerService.dto.CustomerDto;
import BookStoreManagement.CustomerService.exception.CustomerNotFoundException;
import BookStoreManagement.CustomerService.model.Customer;
import BookStoreManagement.CustomerService.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Convertor convertor;

    public CustomerServiceImplementation(CustomerRepository customerRepository, Convertor convertor) {
        this.customerRepository = customerRepository;
        this.convertor = convertor;
    }


    @Override
    public List<CustomerDto> getallCustomer() {
        return convertor.toDTOList(customerRepository.findAll());
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("No customer with this CustomerId"));
    }

    @Override
    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer newCustomer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("The Id which you give is not present in the Customers"));
        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setEmail(customer.getEmail());
        return newCustomer;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("The Id which you give is not present in the Customers"));
        customerRepository.delete(customer);
    }




}
