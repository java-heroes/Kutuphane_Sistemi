package kodluyoruz.librarysystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.BookService;
import kodluyoruz.librarysystem.core.utilities.Business.BusinessRules;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.ErrorResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessDataResult;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessResult;
import kodluyoruz.librarysystem.dataAccess.abstracts.BookDao;
import kodluyoruz.librarysystem.dataAccess.abstracts.RentalDao;
import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.concretes.Rental;
import kodluyoruz.librarysystem.entities.dtos.BookWithCategoryAndWriterDto;

@Service
public class BookManager implements BookService {

    private BookDao bookDao;
    private RentalDao rentalDao;
    @Autowired
    public BookManager(BookDao bookDao,RentalDao rentalDao) {
        super();
        this.bookDao = bookDao;
        this.rentalDao=rentalDao;  }

    @Override
    public DataResult<List<Book>> getAll() {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<Book>>(bookDao.findAll(), "Kitaplar listelendi");
    }

    @Override
    public Result addBook(Book book) {
        Result result = BusinessRules.Run(
                CheckIfNameExist(book.getName()));
        if (result != null) {
            return result;
        }
        bookDao.save(book);
        return new SuccessResult("Book added successfully.");
    }

    @Override
    public Result update(Book book) {
        bookDao.save(book);
        return new SuccessResult("Kitap guncellendi.");
    }

    @Override
    public Result delete(Integer id) {
        String book = bookDao.getById(id).getName();
        bookDao.deleteById(id);
        return new SuccessResult(book + " kitabı silindi.");
    }

    @Override
    public DataResult<Book> getByBookName(String productName) {
        return new SuccessDataResult<Book>(bookDao.getByName(productName));
    }

    @Override
    public DataResult<List<Book>> getByCategoryId(int id) {

        return new SuccessDataResult<List<Book>>(bookDao.getByCategory_Id(id));
    }

    @Override
    public DataResult<List<Book>> getByCategoryName(String name) {
        return new SuccessDataResult<List<Book>>(bookDao.getByCategory_CategoryName(name), name + "'e ait kitap listesi:");
    }

    @Override
    public DataResult<List<Book>> getByBookNameContains(String bookName) {
        return new SuccessDataResult<List<Book>>(bookDao.getByNameContains(bookName));
    }

    @Override
    public DataResult<List<Book>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        return new SuccessDataResult<List<Book>>(bookDao.findAll(sort), "Alfabeye göre sıralama yapıldı.");
    }

    @Override
    public DataResult<Book> getById(int id) {
        return new SuccessDataResult<Book>(bookDao.getById(id));
    }

    /*public Result NullControl(Book book) {
        if (book.getName() == null
                || book.getNumber_of_pages() == 0
                || book.getPublishDate() == null
                || book.getBarcode_no() == 0
                || book.getDescription() == null
                || book.getCategory().getId() == 0) {
            return new ErrorResult("Please fill all the field!");
        }
        return new SuccessResult();

    }*/

    public Result CheckIfNameExist(String name) {
        List<Book> books = bookDao.findAll();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return new ErrorResult("This book is already exist!");
            }
        }
        return new SuccessResult();
    }

    @Override
	public DataResult<List<BookWithCategoryAndWriterDto>> getBookWithDetail() {
		// TODO Auto-generated method stub
		
		return new SuccessDataResult<List<BookWithCategoryAndWriterDto>>(this.bookDao.getBookWithDetail(),"details listed");
	}

	@Override
	public DataResult<List<Book>> getTheNewest() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.DESC, "publishDate");

        return new SuccessDataResult<List<Book>>(bookDao.findAll(sort), "En Yeniler Listesi");
		
	}

	@Override
	public DataResult<List<Book>> getMostReaded() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.DESC, "rentNum");
		return new SuccessDataResult<List<Book>>(this.bookDao.findAll(sort),"en çok okunanlar listesi");
		
	}


}
