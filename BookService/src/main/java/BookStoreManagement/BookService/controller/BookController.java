package BookStoreManagement.BookService.controller;

import BookStoreManagement.BookService.convertors.DtoEntintyConvertor;
import BookStoreManagement.BookService.dto.BookDto;
import BookStoreManagement.BookService.model.Book;
import BookStoreManagement.BookService.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    private final BookService bookService;
    private final DtoEntintyConvertor dtoEntintyConvertor;

    public BookController(BookService bookService, DtoEntintyConvertor dtoEntintyConvertor) {
        this.bookService = bookService;
        this.dtoEntintyConvertor = dtoEntintyConvertor;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId){
        Book book = bookService.findBook(bookId);
        var bookDto = dtoEntintyConvertor.toDto(book);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto){
        Book book = dtoEntintyConvertor.toEntity(bookDto);
        bookService.addBook(book);
        var dto = dtoEntintyConvertor.toDto(book);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){
        return ResponseEntity.ok(bookService.findAllBook());
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book Deleted");
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long bookId,@Valid @RequestBody BookDto bookDto){
        Book book = dtoEntintyConvertor.toEntity(bookDto);
        bookService.updateBook(bookId,book);
        return ResponseEntity.ok(bookDto);
    }

    @PutMapping("/stock/{id}/{quant}")
    public ResponseEntity<String> reduceStock(@PathVariable Long id , @PathVariable int quant){
        return ResponseEntity.ok(bookService.reduceStock(id,quant));
    }







}
