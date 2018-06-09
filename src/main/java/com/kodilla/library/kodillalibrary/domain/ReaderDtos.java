package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDtos {
    private Long id;
    private String name;
    private String surname;
    private String signUpDate;
}
