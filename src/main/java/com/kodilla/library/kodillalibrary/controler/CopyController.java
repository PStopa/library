package com.kodilla.library.kodillalibrary.controler;

import com.kodilla.library.kodillalibrary.domain.CopyDto;
import com.kodilla.library.kodillalibrary.mapper.CopyMapper;
import com.kodilla.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library/copy")
public class CopyController {
    @Autowired
    private DbService service;

    @Autowired
    private CopyMapper copyMapper;

}
