package kodluyoruz.librarysystem.business.concretes;

import kodluyoruz.librarysystem.business.abstracts.RentalService;
import kodluyoruz.librarysystem.core.exceptions.IdNotFoundException;
import kodluyoruz.librarysystem.core.utilities.Results.*;
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
        if (id != null) {
            return new SuccessDataResult<Rental>(rentalDao.getById(id));
        } else
            throw new IdNotFoundException(id);
    }

    @Override
    public Result add(Rental rental) {
        if(!rental.getBook().isRent()){
        rentalDao.save(rental);
        return new SuccessResult("Rental Is Made Successfully");}
        else
            return new ErrorResult("Rental Already Exist!");
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


	@Override
	public DataResult<List<Rental>> getByUserId(int userId) {		
		return new SuccessDataResult<List<Rental>>(rentalDao.getByUser_Id(userId), "Listeleme başarılı");
	}
}
