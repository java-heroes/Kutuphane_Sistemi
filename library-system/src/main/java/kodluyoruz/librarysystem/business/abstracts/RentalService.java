package kodluyoruz.librarysystem.business.abstracts;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Rental;

import java.util.List;

public interface RentalService {
    DataResult<List<Rental>> getAll();

    DataResult<Rental> getById(Integer id);

    Result add(Rental rental);

    Result update(Rental rental);

    Result delete(Integer id);
    
    DataResult<List<Rental>> getByUserId(Integer id);
    DataResult<List<Rental>> getByUserName(String username);
}
