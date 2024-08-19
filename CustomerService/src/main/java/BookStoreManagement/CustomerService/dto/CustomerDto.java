package BookStoreManagement.CustomerService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public record CustomerDto(
        Long id,

        @NotBlank(message = "Customer name is Mandatory")
        String customerName,

        @NotBlank(message = "Phone Number is necessary")
        String phone,

        @Email(message = "give a proper Email")
        String email
) {
}
