package com.kodilla.library.kodillalibrary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BORROWINGS")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COPY_ID")
    private Copy copyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @Column(name = "BORROW_DATE")
    private Date borrowDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public Borrowing(Copy copyId, Reader reader) {
        this.copyId = copyId;
        this.reader = reader;
    }

    public Borrowing() {
    }

    public Borrowing(Long id, Copy copyId, Reader reader, Date borrowDate, Date returnDate) {
        this.id = id;
        this.copyId = copyId;
        this.reader = reader;
        this.borrowDate = new Date();
        this.returnDate = returnDate;
    }
}
