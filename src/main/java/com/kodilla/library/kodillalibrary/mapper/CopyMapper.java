package com.kodilla.library.kodillalibrary.mapper;

import com.kodilla.library.kodillalibrary.domain.Copy;
import com.kodilla.library.kodillalibrary.domain.CopyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {
    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getStatus(),
                copyDto.getBookId(),
                copyDto.getBorrowings());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getStatus(),
                copy.getBookId(),
                copy.getBorrowings());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(t -> new CopyDto(t.getId(), t.getStatus(), t.getBookId(), t.getBorrowings()))
                .collect(Collectors.toList());
//                .map(t -> new CopyDto(t.getId(), t.getStatus(), t.getBookId()))
//                .collect(Collectors.toList());
    }
}
