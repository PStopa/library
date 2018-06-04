package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDtos {
    private Long id;
    private String bookTitle;
    private String readerName;
    private String readerSurname;
    private String borrowDate;
    private String returnDate;
}

