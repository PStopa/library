package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;

    private String title;

    private String author;

    private int publicationYear;

    private List<Copy> copies;

}