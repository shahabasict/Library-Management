package BookStoreManagement.CustomerService.convertor;

import BookStoreManagement.CustomerService.dto.CustomerDto;
import BookStoreManagement.CustomerService.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convertor {

    public CustomerDto toDto(Customer customer){
        return new CustomerDto(customer.getCustomerId(), customer.getCustomerName(), customer.getPhone(), customer.getEmail());
    }

    public Customer toEntity(CustomerDto dto){
        Customer customer = new Customer();
        customer.setCustomerId(dto.id());
        customer.setCustomerName(dto.customerName());
        customer.setPhone(dto.phone());
        customer.setEmail(dto.email());

        return customer;
    }

    public List<CustomerDto> toDTOList(List<Customer> customerList){
        List<CustomerDto> customerDtos = new ArrayList<>();
        customerList.forEach(customer -> customerDtos.add(toDto(customer)));
        return customerDtos;
    }

}
