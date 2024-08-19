package BookStoreManagement.CustomerService.repository;

import BookStoreManagement.CustomerService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
