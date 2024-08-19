package BookStoreManagement.Order_Service.service;

import BookStoreManagement.Order_Service.dto.OrderDto;
import BookStoreManagement.Order_Service.exceptions.InsufficientsStockException;
import BookStoreManagement.Order_Service.exceptions.OrderNotFoundException;
import BookStoreManagement.Order_Service.fiegnClient.BookService;
import BookStoreManagement.Order_Service.mapper.OrderMapper;

import BookStoreManagement.Order_Service.model.Ordering;
import BookStoreManagement.Order_Service.model.orderStatus;
import BookStoreManagement.Order_Service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookStoreManagement.Order_Service.model.Book;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final BookService bookService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, BookService bookService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.bookService = bookService;
    }


    public Boolean checkStock(Long bookId, int quantity){
        Book book = bookService.getBook(bookId);
        if(book.getBookStock()>=quantity){
            String output = bookService.reduceStock(bookId,quantity);
            System.out.println(output);
            return true;
        }
        else return false;
    }




    @Override
    public Ordering createOrder(OrderDto order) {

        Book book = bookService.getBook(order.bookId());

        if(checkStock(order.bookId(),order.quantity())){
            Ordering ordering = orderMapper.toEntity(order);
            orderRepository.save(ordering);
            return ordering;
        }

        throw new InsufficientsStockException("Stock is Invalid");
    }

    @Override
    public Ordering getOrderById(Long id) {
        Optional<Ordering> ordering = orderRepository.findById(id);
        if(ordering.isPresent()){
            return ordering.get();
        }
        throw new OrderNotFoundException("OrderNot Found") ;
    }

    @Override
    public List<Ordering> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Ordering updateOrder(Long id, OrderDto dto) {
        Optional<Ordering> ordering = orderRepository.findById(id);
        if(ordering.isPresent()){
            Ordering order = ordering.get();
            if(checkStock(dto.bookId(), dto.quantity())){
                order.setQuantity(dto.quantity());
                order.setBookId(dto.bookId());
                orderRepository.save(order);
                return order;
            }
            throw new OrderNotFoundException("Order Not Found") ;
        }
        throw new OrderNotFoundException("Order Not Found") ;
    }

    @Override
    public Ordering deleteOrder(Long id) {
        Optional<Ordering> ordering = orderRepository.findById(id);
        if(ordering.isPresent()){
            Ordering order = ordering.get();
            order.setStatus(orderStatus.CANCELLED);
            orderRepository.save(order);
            return order;
        }
        throw new OrderNotFoundException("OrderNot Found") ;
    }

}