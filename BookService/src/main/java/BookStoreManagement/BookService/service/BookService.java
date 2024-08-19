package BookStoreManagement.BookService.service;

import BookStoreManagement.BookService.dto.BookDto;
import BookStoreManagement.BookService.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public Book findBook(Long bookId);

    public List<BookDto> findAllBook();

    public Book addBook(Book book);

    public Book updateBook(Long bookId,Book book);

    void deleteBook(Long id);

    public String reduceStock(Long id , int quant);

}
