package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.entities.concretes.Book;

public interface BookService {
  List<Book> getAll();
  List<Book> getAllSorted();
  Book getById(int id);
  void addBook(Book book);
  void update(Book book);
  void delete(Integer id);
  Book getByBookName(String productName);
  List<Book> getByCategoryId(int id);
  List<Book> getByCategoryName(String  name);
  List<Book> getByBookNameContains(String bookName);
}
