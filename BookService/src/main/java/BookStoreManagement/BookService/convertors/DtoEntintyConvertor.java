package BookStoreManagement.BookService.convertors;

import BookStoreManagement.BookService.dto.BookDto;
import BookStoreManagement.BookService.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoEntintyConvertor {

    public BookDto toDto(Book book){
        return new BookDto(book.getBookId(), book.getBookTitle(),
                book.getBookAuthor(), book.getBookPrice(), book.getBookStock());
    }

    public Book toEntity(BookDto bookDto){
        Book book = new Book();
        book.setBookId(bookDto.authId());
        book.setBookTitle(bookDto.bookTitle());
        book.setBookAuthor(bookDto.bookAuthor());
        book.setBookPrice(bookDto.bookPrice());
        book.setBookStock(bookDto.bookStock());

        return book;
    }

    public List<BookDto> bookDtoList(List<Book> bookList){
        List<BookDto> books = new ArrayList<>();
        bookList.forEach(book -> books.add(toDto(book)));
        return books;
    }




}
