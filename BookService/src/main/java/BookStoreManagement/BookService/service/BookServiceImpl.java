package BookStoreManagement.BookService.service;

import BookStoreManagement.BookService.convertors.DtoEntintyConvertor;
import BookStoreManagement.BookService.dto.BookDto;
import BookStoreManagement.BookService.exception.BookNotFoundException;
import BookStoreManagement.BookService.model.Book;
import BookStoreManagement.BookService.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final DtoEntintyConvertor dtoEntintyConvertor;

    public BookServiceImpl(BookRepository bookRepository, DtoEntintyConvertor dtoEntintyConvertor) {
        this.bookRepository = bookRepository;
        this.dtoEntintyConvertor = dtoEntintyConvertor;
    }


    @Override
    public Book findBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("Book With This Id not Found"));
    }

    @Override
    public List<BookDto> findAllBook() {
        return dtoEntintyConvertor.bookDtoList(bookRepository.findAll());
    }

    @Override
    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("No book under the Id given by You"));
        existingBook.setBookTitle(book.getBookTitle());
        existingBook.setBookAuthor(book.getBookAuthor());
        existingBook.setBookPrice(book.getBookPrice());
        existingBook.setBookStock(book.getBookStock());

        return existingBook;

    }

    @Override
    public void deleteBook(Long id) {

      var book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book Not Found"));
      bookRepository.delete(book);
    }

    @Override
    public String reduceStock(Long id, int quant) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book book1 = book.get();
            int stock = book1.getBookStock() - quant;
            book1.setBookStock(stock);
            bookRepository.save(book1);
            return "Reduced Stock";
        }
        throw new BookNotFoundException("Book Invalid Id");
    }


}