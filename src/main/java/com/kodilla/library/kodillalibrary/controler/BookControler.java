package com.kodilla.library.kodillalibrary.controler;


import com.kodilla.library.kodillalibrary.domain.BookDto;
import com.kodilla.library.kodillalibrary.mapper.BookMapper;
import com.kodilla.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/library/book")
public class BookControler {
    @Autowired
    private DbService service;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long id) throws BookNotFoundException{
        return bookMapper.mapToBookDto(service.getBook(id).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteBook(@RequestParam String id) {
        service.deleteBook(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook")
    public void createBook(@RequestBody BookDto bookDto) {
        service.saveBook(bookMapper.mapToBook(bookDto));
    }

}
