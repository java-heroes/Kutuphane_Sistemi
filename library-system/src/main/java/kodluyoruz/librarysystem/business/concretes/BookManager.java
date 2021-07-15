package kodluyoruz.librarysystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.BookService;
import kodluyoruz.librarysystem.dataAccess.abstracts.BookDao;
import kodluyoruz.librarysystem.entities.concretes.Book;

@Service
public class BookManager implements BookService{

	private BookDao bookDao;
	@Autowired
	public BookManager(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Book getById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getById(id);
	}

	@Override
	public void addBook(Book book) {
		bookDao.save(book);
			
	}

	@Override
	public void update(Book book) {
		bookDao.save(book);
		
	}

	@Override
	public void delete(Integer id) { 
		bookDao.deleteById(id);	
	}

	@Override
	public Book getByBookName(String productName) {
		return bookDao.getByName(productName);
		}

	@Override
	public List<Book> getByCategoryId(int id) {
		
		return bookDao.getByCategory_Id(id);
	}

	@Override
	public List<Book> getByCategoryName(String name) {
		return bookDao.getByCategory_CategoryName(name);
	}

	@Override
	public List<Book> getByBookNameContains(String bookName) {
		return bookDao.getByNameContains(bookName);
	}

	@Override
	public List<Book> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC,"name");
		
		return bookDao.findAll(sort);
	}

}
