package BookStoreManagement.CustomerService.service;

import BookStoreManagement.CustomerService.dto.CustomerDto;
import BookStoreManagement.CustomerService.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<CustomerDto> getallCustomer();

    public Customer getCustomerById(Long customerId);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Long customerId, Customer customer);

    void deleteCustomer(Long customerId);


}
