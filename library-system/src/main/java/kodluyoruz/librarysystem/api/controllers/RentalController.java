package kodluyoruz.librarysystem.api.controllers;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessResult;
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

}
