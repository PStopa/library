package com.kodilla.library.kodillalibrary.repository;

import com.kodilla.library.kodillalibrary.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {

    @Override
    Borrowing save(Borrowing borrowing);

    Optional<Borrowing> findById(Long id);

    @Override
    List<Borrowing> findAll();

    @Override
    void delete(Long id);
}
