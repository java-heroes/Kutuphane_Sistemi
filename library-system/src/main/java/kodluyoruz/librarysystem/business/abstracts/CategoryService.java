package kodluyoruz.librarysystem.business.abstracts;

import kodluyoruz.librarysystem.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    void addCategory(Category category);
    void update(Category category);
    void delete(Integer id);
    Category getByCategoryName(String categoryName);
}
