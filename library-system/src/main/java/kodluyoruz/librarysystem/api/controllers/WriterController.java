package kodluyoruz.librarysystem.api.controllers;
import kodluyoruz.librarysystem.business.abstracts.WriterService;
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
@RequestMapping("/writers")

public class WriterController {
    private WriterService writerService;

    @Autowired
    public WriterController(WriterService writerService) {
        super();
        this.writerService = writerService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.writerService.getAll());
    }

    @GetMapping("/getbywritername")
    public ResponseEntity<?> getByWriterName(@RequestParam String writerName){
        //System.out.println(id);
        return ResponseEntity.ok(this.writerService.getByWriterName(writerName));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Writer writer){
        this.writerService.addWriter(writer);
        return ResponseEntity.ok("yazar eklendi");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        this.writerService.delete(id);
        return ResponseEntity.ok("yazar silindi");
    }
}