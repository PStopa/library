package com.kodilla.library.kodillalibrary.controler;

import com.kodilla.library.kodillalibrary.domain.Borrowing;
import com.kodilla.library.kodillalibrary.domain.BorrowingDto;
import com.kodilla.library.kodillalibrary.domain.BorrowingDtos;
import com.kodilla.library.kodillalibrary.domain.Copy;
import com.kodilla.library.kodillalibrary.mapper.BorrowingMapper;
import com.kodilla.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/borrowing")
public class BorrowingController {
    @Autowired
    private DbService service;
    @Autowired
    private BorrowingMapper borrowingMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowings")
    public List<BorrowingDtos> getBorrowings() {
        return borrowingMapper.mapToBorrowingDtoList(service.getAllBorrowings());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowing")
    public BorrowingDtos getBorrowing(@RequestParam Long id) throws BorrowingNotFoundException{
        return borrowingMapper.mapToBorrowingDto(service.getBorrowing(id).orElseThrow(BorrowingNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBorrowing")
    public void deleteBorrowing(@RequestParam String id) {
        service.deleteBorrowing(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBorrowing")
    public BorrowingDtos updateBorrowing(@RequestBody BorrowingDto borrowingDto) {
        return borrowingMapper.mapToBorrowingDto(service.saveBorrowing(borrowingMapper.mapToBorrowing(borrowingDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing")
    public void createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        Optional<Copy> copy = service.getCopy(borrowingDto.getCopyId().getId());
        if(copy.get().getStatus().equals("w obiegu")) {
            service.saveBorrowing(borrowingMapper.mapToBorrowing(borrowingDto));
            copy.get().setStatus("wypozyczona");
            service.saveCopy(copy.get());
        }
        else {
            System.out.println("Book is borrowed or lost");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "returnBook")
    public void returnBook(@RequestBody BorrowingDto borrowingDto) {
        Optional<Copy> copy = service.getCopy(borrowingDto.getCopyId().getId());
        Optional<Borrowing> borrowing = service.getBorrowing(borrowingDto.getId());

        if(borrowing.get().getReturnDate() == null) {

            borrowing.get().setReturnDate(LocalDate.now().toString());
            service.saveBorrowing(borrowing.get());

            copy.get().setStatus("w obiegu");
            service.saveCopy(copy.get());
        }
        else {
            System.out.println("Wrong borrowing");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "lostBook")
    public void lostBook(@RequestBody BorrowingDto borrowingDto) {
        Optional<Copy> copy = service.getCopy(borrowingDto.getCopyId().getId());
        if(copy.get().getStatus().equals("wypozyczona")) {
            copy.get().setStatus("zagubiona");
            service.saveCopy(copy.get());
        }
        else {
            System.out.println("Wrong borrowing");
        }
    }
}