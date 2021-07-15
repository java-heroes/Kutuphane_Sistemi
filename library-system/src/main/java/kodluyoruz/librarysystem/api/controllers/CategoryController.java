package kodluyoruz.librarysystem.api.controllers;
import kodluyoruz.librarysystem.business.abstracts.CategoryService;
import kodluyoruz.librarysystem.entities.concretes.Category;
import kodluyoruz.librarysystem.entities.concretes.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired()
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @GetMapping("/getbycategoryname")
    public ResponseEntity<?> getByCategoryName(@RequestParam String categoryName){
        //System.out.println(id);
        return ResponseEntity.ok(this.categoryService.getByCategoryName(categoryName));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category){
        this.categoryService.addCategory(category);
        return ResponseEntity.ok("kategori eklendi");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        this.categoryService.delete(id);
        return ResponseEntity.ok("kategori silindi");
    }
}
