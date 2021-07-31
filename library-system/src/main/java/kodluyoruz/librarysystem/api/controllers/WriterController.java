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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getbywritername")
    public DataResult<List<Writer>> getByWriterName(@RequestParam String writerName) {
        //System.out.println(id);
        return this.writerService.getByWriterName(writerName);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Writer writer) {
        return this.writerService.addWriter(writer);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return this.writerService.delete(id);
       }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object>handleValidationException(MethodArgumentNotValidException exceptions){
    	Map<String,String> validationErrors=new HashMap<String,String>();
        for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {
        	validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        	
        }
      ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Validations errors");
      return errors;
    }
}