package kodluyoruz.librarysystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
