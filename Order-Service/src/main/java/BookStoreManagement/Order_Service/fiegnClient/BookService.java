package BookStoreManagement.Order_Service.fiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import BookStoreManagement.Order_Service.model.Book;

@FeignClient(name = "Book",url = "http://localhost:8100/book")
public interface BookService{

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id);

    @PutMapping("/stock/{id}/{quant}")
    String reduceStock(@PathVariable Long id , @PathVariable int quant);


}
