package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.entities.concretes.Category;


public interface CategoryService {

	  List<Category> getAll();
	  List<Category> getAllSorted();
	  Category getById(int id);
	  void add(Category category);
	  void update(Category category);
	  void delete(Category id);
}
