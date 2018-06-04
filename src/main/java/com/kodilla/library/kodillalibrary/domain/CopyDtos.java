package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDtos {
    private Long id;
    private String status;
    private Long bookId;

    public CopyDtos(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
