package BookStoreManagement.Order_Service.mapper;

import BookStoreManagement.Order_Service.dto.OrderDto;
import BookStoreManagement.Order_Service.model.Ordering;
import BookStoreManagement.Order_Service.model.orderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Ordering toEntity(OrderDto dto){
        Ordering ordering = new Ordering();
        ordering.setBookId(dto.bookId());
        ordering.setQuantity(dto.quantity());
        ordering.setStatus(orderStatus.CONFIRMERD);
        return ordering;
    }

}