package kodluyoruz.librarysystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.librarysystem.business.abstracts.BookService;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Book;

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

    @GetMapping("/getbyid")
    public DataResult<Book> getById(int id) {
        return this.bookService.getById(id);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<Book>> getAllSorted() {
        return this.bookService.getAllSorted();
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

    @PostMapping("/add")
    public Result add(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Book book) {
        return this.bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return this.bookService.delete(id);

    }

}
