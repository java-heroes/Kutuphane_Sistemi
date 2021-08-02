package kodluyoruz.librarysystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.dtos.BookWithCategoryAndWriterDto;

public interface BookDao extends JpaRepository<Book, Integer> {
    //Book getById (int id);
    Book getByName(String productName);

    List<Book> getByCategory_Id(int id);

    List<Book> getByCategory_CategoryName(String categoryName);

    List<Book> getByNameContains(String bookName);
    
    @Query("Select new kodluyoruz.librarysystem.entities.dtos.BookWithCategoryAndWriterDto(b.id,b.name,c.categoryName,w.name)"
    	    +" From Category c Inner Join c.books b"
    		+" Inner Join b.writer w")
    	List<BookWithCategoryAndWriterDto> getBookWithDetail();
    
    
}
