package com.kodilla.library.kodillalibrary.mapper;

import com.kodilla.library.kodillalibrary.domain.Borrowing;
import com.kodilla.library.kodillalibrary.domain.BorrowingDto;
import com.kodilla.library.kodillalibrary.domain.BorrowingDtos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowingMapper {
    public Borrowing mapToBorrowing(final BorrowingDto borrowingDto) {
        return new Borrowing(borrowingDto.getId() ,borrowingDto.getCopyId(), borrowingDto.getReader(), borrowingDto.getBorrowDate(), borrowingDto.getReturnDate());
    }

    public BorrowingDtos mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDtos(borrowing.getId(), borrowing.getCopyId().getBookId().getTitle(), borrowing.getReader().getName(), borrowing.getReader().getSurname(), borrowing.getBorrowDate(), borrowing.getReturnDate());
    }

    public List<BorrowingDtos> mapToBorrowingDtoList(final List<Borrowing> borrowingList) {
        return borrowingList.stream()
                .map(t -> new BorrowingDtos(t.getId(),t.getCopyId().getBookId().getTitle(),t.getReader().getName(), t.getReader().getSurname(), t.getBorrowDate(), t.getReturnDate()))
                .collect(Collectors.toList());
    }
}
