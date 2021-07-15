package kodluyoruz.librarysystem.business.concretes;

import kodluyoruz.librarysystem.business.abstracts.CategoryService;
import kodluyoruz.librarysystem.dataAccess.abstracts.CategoryDao;
import kodluyoruz.librarysystem.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    @Autowired
    public CategoryManager(CategoryDao categoryDao){
        super();
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryDao.getById(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Category getByCategoryName(String categoryName) {
        return null;
    }

//    @Override
//    public Category getByCategoryName(String categoryName) {
//        return categoryDao.getByName(categoryName);
//    }
}
