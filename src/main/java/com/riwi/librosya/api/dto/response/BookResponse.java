package com.riwi.librosya.api.dto.response;
import java.util.List;

import com.riwi.librosya.domain.entities.Loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String autor;
    private int publicationYear;
    private String genre;
    private String isbn;
    private List<Loan> loans;
}
