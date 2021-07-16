package kodluyoruz.librarysystem.business.concretes;

import kodluyoruz.librarysystem.business.abstracts.RentalService;
import kodluyoruz.librarysystem.core.exceptions.IdNotFoundException;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessDataResult;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessResult;
import kodluyoruz.librarysystem.dataAccess.abstracts.RentalDao;
import kodluyoruz.librarysystem.entities.concretes.Rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalManager implements RentalService {
    private RentalDao rentalDao;
    @Autowired
    public RentalManager(RentalDao rentalDao) {
        super();
        this.rentalDao = rentalDao;
    }


    @Override
    public DataResult<List<Rental>> getAll() {
        return new SuccessDataResult<List<Rental>>(rentalDao.findAll());
    }

    @Override
    public DataResult<Rental> getById(Integer id) {
        if(id!=null){
        return new SuccessDataResult<Rental>(rentalDao.getById(id));}
        else
            throw new IdNotFoundException(id);
    }

    @Override
    public Result add(Rental rental) {
        rentalDao.save(rental);
        return new SuccessResult("");
    }

    @Override
    public Result update(Rental rental) {
        rentalDao.save(rental);
        return new SuccessResult("updated");
    }

    @Override
    public Result delete(Integer id) {
    	rentalDao.deleteById(id);
        return new SuccessResult("Rental deleted.");
    }
}
