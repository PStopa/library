package com.kodilla.library.kodillalibrary.mapper;

import com.kodilla.library.kodillalibrary.domain.Reader;
import com.kodilla.library.kodillalibrary.domain.ReaderDto;
import com.kodilla.library.kodillalibrary.domain.ReaderDtos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getSignUpDate(),
                readerDto.getBorrowings());
    }

    public ReaderDtos mapToReaderDto(final Reader reader) {
        return new ReaderDtos(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getSignUpDate());
    }

    public List<ReaderDtos> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(t -> new ReaderDtos(t.getId(),t.getName(),t.getSurname(),t.getSignUpDate()))
                .collect(Collectors.toList());
    }
}
