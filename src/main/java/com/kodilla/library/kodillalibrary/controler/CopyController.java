package com.kodilla.library.kodillalibrary.controler;

import com.kodilla.library.kodillalibrary.domain.CopyDto;
import com.kodilla.library.kodillalibrary.mapper.CopyMapper;
import com.kodilla.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/copy")
public class CopyController {
    @Autowired
    private DbService service;

    @Autowired
    private CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<CopyDto> getCopies() {
        return copyMapper.mapToCopyDtoList(service.getAllCopy());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public CopyDto getCopy(@RequestParam Long id) throws CopyNotFoundException {
        return copyMapper.mapToCopyDto(service.getCopy(id).orElseThrow(CopyNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(@RequestParam String id) {
        service.deleteCopy(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopy")
    public CopyDto updateCopy(@RequestBody CopyDto copyDto) {
        return copyMapper.mapToCopyDto(service.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCopy")
    public void createCopy(@RequestBody CopyDto copyDto) {
        service.saveCopy(copyMapper.mapToCopy(copyDto));
    }

}
