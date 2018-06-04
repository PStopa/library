package com.kodilla.library.kodillalibrary.mapper;

import com.kodilla.library.kodillalibrary.domain.Copy;
import com.kodilla.library.kodillalibrary.domain.CopyDto;
import com.kodilla.library.kodillalibrary.domain.CopyDtos;
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

    public CopyDtos mapToCopyDto(final Copy copy) {
        return new CopyDtos(
                copy.getId(),
                copy.getStatus(),
                copy.getBookId().getId());
    }

    public List<CopyDtos> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(t -> new CopyDtos(t.getId(), t.getStatus(), t.getBookId().getId()))
                .collect(Collectors.toList());
    }
}
