//package kodluyoruz.librarysystem.api.controllers;
//
//
//import kodluyoruz.librarysystem.business.abstracts.KiralamaService;
//
//import kodluyoruz.librarysystem.entities.concretes.Kiralama;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/rent")
//public class KiralamaController {
//    private KiralamaService kiralamaService;
//
//    @Autowired
//    public KiralamaController(KiralamaService kiralamaService) {
//        this.kiralamaService = kiralamaService;
//    }
//
//
//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAll(){
//        return ResponseEntity.ok(this.kiralamaService.getAll());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<?> add(@RequestBody Kiralama kiralama){
//        this.kiralamaService.KiralamaYap(kiralama);
//        return ResponseEntity.ok("Kiralama yapilmis");
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable int id){
//        this.kiralamaService.delete(id);
//        return ResponseEntity.ok("Kiralama iptal edilmis");
//    }
//
//}
