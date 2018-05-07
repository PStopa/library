package com.kodilla.library.kodillalibrary.controler;

import com.kodilla.library.kodillalibrary.domain.ReaderDto;
import com.kodilla.library.kodillalibrary.mapper.ReaderMapper;
import com.kodilla.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library/reader")
public class ReaderController {
    @Autowired
    private DbService service;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(service.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(@RequestParam Long id) throws ReaderNotFoundException{
        return readerMapper.mapToReaderDto(service.getReader(id).orElseThrow(ReaderNotFoundException::new));
    }
}
