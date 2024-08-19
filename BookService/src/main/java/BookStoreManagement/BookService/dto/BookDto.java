package BookStoreManagement.BookService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        Long authId,

        @NotBlank(message = "Title Shouldnt be Blank")
        String bookTitle,

        @NotBlank(message = "Book Author Shouldn't be blank")
        String bookAuthor,

        @NotNull
        double bookPrice,

        @NotNull
        int bookStock

) {
}
