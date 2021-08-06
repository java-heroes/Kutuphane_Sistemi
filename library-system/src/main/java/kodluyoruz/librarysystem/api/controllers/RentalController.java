package kodluyoruz.librarysystem.api.controllers;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessResult;

import java.util.List;

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
    public DataResult<?> getAll() {
        return this.rentalService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Rental rental) {
       return this.rentalService.add(rental);

    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
       return this.rentalService.delete(id);

    }
    @PutMapping("/update")
    public Result update(@RequestBody Rental rental){
           return  this.rentalService.update(rental);
    }

    @GetMapping("/getrentalbyid/{id}")
    public DataResult<List<Rental>> getRentalByUserId(@PathVariable("id") int id) {
        return this.rentalService.getByUserId(id);
    }
    @GetMapping("/getrentalbyusername")
    public DataResult<List<Rental>> getRentalByUsername(@RequestParam String username) {
        return this.rentalService.getByUserName(username);
    }
}
