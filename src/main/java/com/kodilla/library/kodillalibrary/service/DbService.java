package com.kodilla.library.kodillalibrary.service;

import com.kodilla.library.kodillalibrary.domain.*;
import com.kodilla.library.kodillalibrary.repository.BookRepository;
import com.kodilla.library.kodillalibrary.repository.BorrowingRepository;
import com.kodilla.library.kodillalibrary.repository.CopyRepository;
import com.kodilla.library.kodillalibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BorrowingRepository borrowingRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
    public List<Copy> getAllCopy() {
        return copyRepository.findAll();
    }
    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }
    public Optional<Reader> getReader(final Long id) {
        return readerRepository.findById(id);
    }
    public Optional<Copy> getCopy(final Long id) {
        return copyRepository.findById(id);
    }
    public Optional<Borrowing> getBorrowing(final Long id) {
        return borrowingRepository.findById(id);
    }

    public Book saveBook(final Book book) {
        book.getCopies().stream()
                .forEach(t -> t.setBookId(book));
        return bookRepository.save(book);
    }
    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }
    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }
    public Borrowing saveBorrowing(final Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public void deleteBook(final Long id) {
        bookRepository.delete(id);
    }
    public void deleteReader(final Long id) {
        readerRepository.delete(id);
    }
    public void deleteCopy(final Long id) {
        copyRepository.delete(id);
    }
    public void deleteBorrowing(final Long id) {
        borrowingRepository.delete(id);
    }

    public List<Copy> countByStatus(final String bookStatus) {
        return copyRepository.findByStatus(bookStatus);
    }

    public void saveTest() {
        Book book = new Book("titlesTest2", "authorTest2", 2222);
        Copy copy = new Copy("statusTest2");
        copy.setBookId(book);
        book.getCopies().add(copy);

        bookRepository.save(book);
    }
}
