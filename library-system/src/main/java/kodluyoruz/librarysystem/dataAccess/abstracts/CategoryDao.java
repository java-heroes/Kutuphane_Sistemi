package kodluyoruz.librarysystem.dataAccess.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    //Category getByName(String categoryName);


}
