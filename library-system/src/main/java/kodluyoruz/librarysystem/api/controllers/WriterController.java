package kodluyoruz.librarysystem.api.controllers;

import kodluyoruz.librarysystem.business.abstracts.WriterService;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.ErrorDataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.concretes.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/writers")

public class WriterController {
    private WriterService writerService;

    @Autowired
    public WriterController(WriterService writerService) {
        super();
        this.writerService = writerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Writer>> getAll() {
        return this.writerService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<List<Writer>> getById(int id) {
        return this.writerService.getById(id);
    }

    @GetMapping("/getbywritername")
    public DataResult<Writer> getByWriterName(@RequestParam String writerName) {
        //System.out.println(id);
        return this.writerService.getByWriterName(writerName);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Writer writer) {
        return this.writerService.addWriter(writer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody Writer writer) {
        return this.writerService.update(writer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return this.writerService.delete(id);
       }
  
}