package kodluyoruz.librarysystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Book;

public interface BookDao extends JpaRepository<Book,Integer>{

	
}
