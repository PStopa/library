package com.kodilla.library.kodillalibrary.service;

import com.kodilla.library.kodillalibrary.domain.Book;
import com.kodilla.library.kodillalibrary.domain.Reader;
import com.kodilla.library.kodillalibrary.domain.ReaderDto;
import com.kodilla.library.kodillalibrary.repository.BookRepository;
import com.kodilla.library.kodillalibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(final Long id) {
        bookRepository.delete(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
    public Optional<Reader> getReader(final Long id) {
        return readerRepository.findById(id);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long id) {
        readerRepository.delete(id);
    }
}
