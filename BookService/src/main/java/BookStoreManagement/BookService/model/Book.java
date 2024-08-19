package BookStoreManagement.BookService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private double bookPrice;
    private int bookStock;

}
