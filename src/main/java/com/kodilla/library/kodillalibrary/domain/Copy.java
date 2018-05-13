package com.kodilla.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COPIES")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS")
    private String status;


    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book book) {
        this.bookId = book;
    }

    private List<Borrowing> borrowings = new ArrayList<>();

    @Column(name = "BORROWINGS_ID")
    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "copyId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
