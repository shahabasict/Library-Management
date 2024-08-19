package BookStoreManagement.Order_Service.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    Long id;

    String bookTitle;

    String bookAuthor;

    private double bookPrice;

    private int bookStock;

}