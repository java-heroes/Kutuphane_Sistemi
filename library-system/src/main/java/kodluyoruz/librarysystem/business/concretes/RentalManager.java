package kodluyoruz.librarysystem.business.concretes;

import kodluyoruz.librarysystem.business.abstracts.RentalService;
import kodluyoruz.librarysystem.core.exceptions.IdNotFoundException;
import kodluyoruz.librarysystem.core.utilities.Business.BusinessRules;
import kodluyoruz.librarysystem.core.utilities.Results.*;
import kodluyoruz.librarysystem.dataAccess.abstracts.BookDao;
import kodluyoruz.librarysystem.dataAccess.abstracts.RentalDao;
import kodluyoruz.librarysystem.entities.concretes.Rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalManager implements RentalService {
    private RentalDao rentalDao;
    private BookDao bookDao;
    @Autowired
    public RentalManager(RentalDao rentalDao,BookDao bookDao) {
        super();
        this.rentalDao = rentalDao;
        this.bookDao=bookDao;
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

    	int book_id=rental.getBook().getId();
        if(!this.bookDao.findById(book_id).get().isRent())
        {    
        	//System.out.println("burayaaaa baaaakkkk"+rental.getBook().getName());
        	rentalDao.save(rental);
        	this.bookDao.findById(book_id).get().setRent(true);
        	this.bookDao.findById(book_id).get().setRentNum(this.bookDao.findById(book_id).get().getRentNum()+1);
        	bookDao.save(this.bookDao.findById(book_id).get());
        return new SuccessResult("Rental Is Made Successfully");
        }
        else {
            return new ErrorResult("Rental Already Exist!");
        }
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
	public DataResult<List<Rental>> getByUserId(Integer id) {		
		return new SuccessDataResult<List<Rental>>(this.rentalDao.getByUser_Id(id), "Listeleme başarılı");
	}


	@Override
	public DataResult<List<Rental>> getByUserName(String username) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Rental>>(this.rentalDao.getByUser_Username(username),"Listeleme başarılı");	
		}
	
	/*public Result IsRentable(Rental rental,int id){
        
             List<Rental> rentals = rentalDao.findAll();
           
             for(Rental rent :rentals) {
            	  System.out.println("buraya baaaaakkkk"+rent.getBook().getId());
            	 if((rent.getBook().getId()==id)
            			 && (rent.getTeslim_tarihi().getTime() >= rental.getTeslim_tarihi().getTime())
            			 && (rent.getAlis_tarih().getTime()<=rental.getAlis_tarih().getTime())) {
            		 return new ErrorResult("Seçilen tarihler arasında kitap kirada");
            	 }
            	 
             }
             
             return new SuccessResult("Kitap başarıyla kiralandı.");
         
     }*/
}
