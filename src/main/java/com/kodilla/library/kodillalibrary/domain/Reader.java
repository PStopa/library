package com.kodilla.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "SIGN_UP_DATE")
    private String signUpDate;

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrowing> borrowings = new ArrayList<>();

    public Reader(Long id, String name, String surname, String signUpDate, List<Borrowing> borrowings) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.borrowings = borrowings;
        this.signUpDate = LocalDate.now().toString();
    }

    public Reader(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.signUpDate = LocalDate.now().toString();
    }

    public Reader() {
    }
}
