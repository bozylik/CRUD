package com.vaynberg.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientAccountRequest(
        @NotBlank(message = "Имя обязательно")
        @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
        String fullName,

        @NotBlank(message = "Гендер (пол) обязателен")
        @Pattern(regexp = "^[MF]$", message = "Гендер должен быть 1 символом (M/F)")
        String gender
) {

}
