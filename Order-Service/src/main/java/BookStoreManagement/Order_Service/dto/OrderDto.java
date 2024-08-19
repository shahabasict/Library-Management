package BookStoreManagement.Order_Service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

public record OrderDto(
        Long bookId,

        int quantity
        ) {





}
