package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {
    private Long id;
    private String status;
    private Book bookId;
    private List<Borrowing> borrowings;

    public CopyDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
