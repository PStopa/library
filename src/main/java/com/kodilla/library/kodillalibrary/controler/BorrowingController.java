package com.kodilla.library.kodillalibrary.controler;

import com.kodilla.library.kodillalibrary.domain.BorrowingDto;
import com.kodilla.library.kodillalibrary.mapper.BorrowingMapper;
import com.kodilla.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/borrowing")
public class BorrowingController {
    @Autowired
    private DbService service;
    @Autowired
    private BorrowingMapper borrowingMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowings")
    public List<BorrowingDto> getBorrowings() {
        return borrowingMapper.mapToBorrowingDtoList(service.getAllBorrowings());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowing")
    public BorrowingDto getBorrowing(@RequestParam Long id) throws BorrowingNotFoundException{
        return borrowingMapper.mapToBorrowingDto(service.getBorrowing(id).orElseThrow(BorrowingNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBorrowing")
    public void deleteBorrowing(@RequestParam String id) {
        service.deleteBorrowing(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBorrowing")
    public BorrowingDto updateBorrowing(@RequestBody BorrowingDto borrowingDto) {
        return borrowingMapper.mapToBorrowingDto(service.saveBorrowing(borrowingMapper.mapToBorrowing(borrowingDto)));
    }

}
