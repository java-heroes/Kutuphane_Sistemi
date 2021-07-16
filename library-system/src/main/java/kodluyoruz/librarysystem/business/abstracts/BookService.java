package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Book;

public interface BookService {
  DataResult<List<Book>> getAll();
  DataResult<Book> getById(int id);
  DataResult<List<Book>> getAllSorted();
  Result addBook(Book book);
  Result update(Book book);
  Result delete(Integer id);
  DataResult<Book> getByBookName(String productName);
  DataResult<List<Book>> getByCategoryId(int id);
  DataResult<List<Book>> getByCategoryName(String  name);
  DataResult<List<Book>> getByBookNameContains(String bookName);
}
