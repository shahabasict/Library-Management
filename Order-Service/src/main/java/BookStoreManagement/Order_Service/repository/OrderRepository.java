package BookStoreManagement.Order_Service.repository;

import BookStoreManagement.Order_Service.model.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordering,Long> {
}
