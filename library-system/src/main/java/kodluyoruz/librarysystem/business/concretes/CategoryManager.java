package kodluyoruz.librarysystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.CategoryService;
import kodluyoruz.librarysystem.core.utilities.Business.BusinessRules;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.ErrorResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessDataResult;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessResult;
import kodluyoruz.librarysystem.dataAccess.abstracts.CategoryDao;
import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        super();
        this.categoryDao = categoryDao;
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>(categoryDao.findAll());
    }

    @Override
    public DataResult<List<Category>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "categoryName");
        return new SuccessDataResult<List<Category>>(categoryDao.findAll(sort));
    }

    @Override
    public DataResult<Category> getById(int id) {
        return new SuccessDataResult<Category>(categoryDao.getById(id));
    }

    @Override
    public Result add(Category category) {
        Result result = BusinessRules.Run(CheckIfNameExist(category.getCategoryName()),
                NullControl(category));
        if (result != null) {
            return result;
        }
        categoryDao.save(category);
        return new SuccessResult(category.getCategoryName() + " category successfully added.");
    }

    @Override
    public Result update(Category category) {
        Result result = BusinessRules.Run(CheckIfNameExist(category.getCategoryName()),
                NullControl(category));
        if (result != null) {
            return result;
        }
        categoryDao.save(category);
        return new SuccessResult(category.getCategoryName() + " category successfully updated.");
    }

    @Override
    public Result delete(Integer id) {
        String cName = categoryDao.findById(id).get().getCategoryName();
        categoryDao.deleteById(id);
        return new SuccessResult(cName + " silindi.");

    }

    public Result CheckIfNameExist(String name) {
        List<Category> categories = categoryDao.findAll();
        for (Category category : categories) {
            if (category.getCategoryName().equals(name)) {
                return new ErrorResult("This category is already exist!");
            }
        }
        return new SuccessResult();
    }

    public Result NullControl(Category category) {
        if (category.getCategoryName() == null) {
            return new ErrorResult("Category name can not be empty!");
        }
        return new SuccessResult();

    }

}
