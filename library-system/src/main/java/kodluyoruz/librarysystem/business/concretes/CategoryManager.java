package kodluyoruz.librarysystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.CategoryService;
import kodluyoruz.librarysystem.dataAccess.abstracts.CategoryDao;
import kodluyoruz.librarysystem.entities.concretes.Category;
@Service
public class CategoryManager implements CategoryService{

	private CategoryDao categoryDao;
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC, "categoryName");
		return categoryDao.findAll(sort);
	}

	@Override
	public Category getById(int id) {
		return categoryDao.getById(id);
	}

	@Override
	public void add(Category category) {
		categoryDao.save(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.save(category);
	}

	@Override
	public void delete(Category id) {
		categoryDao.delete(id);
	}

}
