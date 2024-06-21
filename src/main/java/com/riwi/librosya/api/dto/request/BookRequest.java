package com.riwi.librosya.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "autor is required")
    private String autor;
    private int publicationYear;
    @NotBlank(message = "genre is required")
    private String genre;
    private String isbn;
}
