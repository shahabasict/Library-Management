package BookStoreManagement.Order_Service.service;

import BookStoreManagement.Order_Service.dto.OrderDto;
import BookStoreManagement.Order_Service.model.Ordering;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    public Ordering createOrder(OrderDto order);

    public Ordering getOrderById(Long id);

    public List<Ordering> getAllOrder();

    public Ordering updateOrder(Long id , OrderDto dto);

    public Ordering deleteOrder(Long id);



}
