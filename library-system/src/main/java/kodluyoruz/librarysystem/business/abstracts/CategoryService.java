package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Category;


public interface CategoryService {

    DataResult<List<Category>> getAll();

    DataResult<List<Category>> getAllSorted();

    DataResult<Category> getById(int id);

    Result add(Category category);

    Result update(Category category);

    Result delete(Integer id);
}
