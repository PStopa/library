package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {
    private Long id;
    private Copy copyId;
    private Reader reader;
    private Date borrowDate;
    private Date returnDate;
}
