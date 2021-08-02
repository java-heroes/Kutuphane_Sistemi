package kodluyoruz.librarysystem.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.librarysystem.business.abstracts.BookService;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.ErrorDataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.concretes.Rental;
import kodluyoruz.librarysystem.entities.dtos.BookWithCategoryAndWriterDto;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }
    
    @GetMapping("/getall")
    public DataResult<List<Book>> getAll() {
        return this.bookService.getAll();
    }
    @GetMapping("/getdetails")
    public DataResult<List<BookWithCategoryAndWriterDto>> getBookWithDetail(){
    	  return this.bookService.getBookWithDetail();
    }
    @GetMapping("/getbyid")
    public DataResult<Book> getById(int id) {
        return this.bookService.getById(id);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<Book>> getAllSorted() {
        return this.bookService.getAllSorted();
    }
    @GetMapping("/getthenewest")
    public DataResult<List<Book>> getTheNewest() {
        return this.bookService.getTheNewest();
    }
    @GetMapping("/getmostreaded")
    public DataResult<List<Book>> getMostReaded() {
        return this.bookService.getMostReaded();
    }
    @GetMapping("/getbybookname")
    public DataResult<Book> getByBookName(@RequestParam String bookName) {
        return this.bookService.getByBookName(bookName);
    }

    @GetMapping("/getbycategoryid")
    public DataResult<List<Book>> getByCategoryId(@RequestParam Integer id) {
        System.out.println(id);
        return this.bookService.getByCategoryId(id);
    }

    @GetMapping("/getbycategoryname")
    public DataResult<List<Book>> getByCategoryName(@RequestParam String name) {
        //System.out.println(id);
        return this.bookService.getByCategoryName(name);
    }

    @GetMapping("/getbybooknamecontains")
    public DataResult<List<Book>> getByBookNameContains(@RequestParam String name) {
        //System.out.println(id);
        return this.bookService.getByBookNameContains(name);
    }
   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Book book) {
        return this.bookService.addBook(book);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody Book book) {
        return this.bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return this.bookService.delete(id);

    }


}
