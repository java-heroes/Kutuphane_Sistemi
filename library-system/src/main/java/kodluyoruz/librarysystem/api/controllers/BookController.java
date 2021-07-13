package kodluyoruz.librarysystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.librarysystem.business.abstracts.BookService;
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
public ResponseEntity<?> getAll(){
	  return ResponseEntity.ok(this.bookService.getAll());
}
@PostMapping("/add")
public ResponseEntity<?> add(@RequestBody Book book){
	this.bookService.addBook(book);
	  return ResponseEntity.ok("kitap eklendi");
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable int id){
	this.bookService.delete(id);
	return ResponseEntity.ok("kitap silindi");
}
}
