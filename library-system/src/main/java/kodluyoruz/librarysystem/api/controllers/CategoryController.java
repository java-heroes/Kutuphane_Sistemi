package kodluyoruz.librarysystem.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.librarysystem.business.abstracts.CategoryService;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<Category>> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Category> getById(int id) {
        return this.categoryService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Category category) {
        return this.categoryService.add(category);

    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody Category category) {
        return this.categoryService.update(category);

    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return this.categoryService.delete(id);

    }

    @GetMapping("/getallshorted")
    public DataResult<List<Category>> getAllShorted() {
        return this.categoryService.getAllSorted();
    }
}
