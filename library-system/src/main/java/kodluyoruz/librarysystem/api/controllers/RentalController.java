package kodluyoruz.librarysystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodluyoruz.librarysystem.business.abstracts.RentalService;
import kodluyoruz.librarysystem.entities.concretes.Rental;

@RestController
@RequestMapping("/rent")
public class RentalController {
    private RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.rentalService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Rental rental){
        this.rentalService.add(rental);
        return ResponseEntity.ok("Kiralama yapilmis");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        this.rentalService.delete(id);
        return ResponseEntity.ok("Kiralama iptal edilmis");
    }

}
