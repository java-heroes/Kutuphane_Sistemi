package kodluyoruz.librarysystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Book;

public interface BookDao extends JpaRepository<Book,Integer>{   
	
	Book getByName(String productName);
	List<Book> getByCategory_Id(int id);
	List<Book> getByCategory_CategoryName(String categoryName);
	List<Book> getByNameContains(String bookName);
	
}
