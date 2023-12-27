package com.bench.msusers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO implements Serializable {

    @NotNull
    @NotBlank
    @JsonProperty("username")
    private String username;

    @NotNull
    @NotBlank
    @JsonProperty("password")
    private String password;

    @NotNull
    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotNull
    @Min(value=7, message="Must be equal or greater than 7")
    @JsonProperty("dni")
    private Long dni;

}