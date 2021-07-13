package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.entities.concretes.Book;

public interface BookService {
  List<Book> getAll();
  Book getById(int id);
  void addBook(Book book);
  void update(Book book);
  void delete(Integer id);
}
