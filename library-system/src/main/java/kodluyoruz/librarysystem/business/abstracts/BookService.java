package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.concretes.Rental;
import kodluyoruz.librarysystem.entities.dtos.BookWithCategoryAndWriterDto;

public interface BookService {
    DataResult<List<Book>> getAll();

    DataResult<Book> getById(int id);

    DataResult<List<Book>> getAllSorted();
    DataResult<List<Book>> getTheNewest();
    DataResult<List<Book>> getMostReaded();

    Result addBook(Book book);

    Result update(Book book);

    Result delete(Integer id);

    DataResult<Book> getByBookName(String productName);

    DataResult<List<Book>> getByCategoryId(int id);

    DataResult<List<Book>> getByCategoryName(String name);

    DataResult<List<Book>> getByBookNameContains(String bookName);
    DataResult<List<BookWithCategoryAndWriterDto>> getBookWithDetail();
}
