package com.kodilla.library.kodillalibrary.mapper;

import com.kodilla.library.kodillalibrary.domain.Reader;
import com.kodilla.library.kodillalibrary.domain.ReaderDto;
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
                readerDto.getSignUpDate());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getSignUpDate());
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(t -> new ReaderDto(t.getId(),t.getName(),t.getSurname(),t.getSignUpDate()))
                .collect(Collectors.toList());
    }
}
