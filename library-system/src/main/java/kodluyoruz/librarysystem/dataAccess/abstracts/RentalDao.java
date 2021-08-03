package kodluyoruz.librarysystem.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Rental;
import kodluyoruz.librarysystem.entities.concretes.User;

public interface RentalDao extends JpaRepository<Rental, Integer> {

	List<Rental> getByUser_Id(int id);
	List<Rental> getByUser_Username(String username);

}
