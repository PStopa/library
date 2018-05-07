package com.kodilla.library.kodillalibrary.mapper;

import com.kodilla.library.kodillalibrary.domain.Copy;
import com.kodilla.library.kodillalibrary.domain.CopyDto;
import org.springframework.stereotype.Component;

@Component
public class CopyMapper {
    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getBookId(),
                copyDto.getStatus());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBookId(),
                copy.getStatus());
    }
}
