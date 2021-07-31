package kodluyoruz.librarysystem.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Rental;
import kodluyoruz.librarysystem.entities.concretes.User;

public interface RentalDao extends JpaRepository<Rental, Integer> {
<<<<<<< HEAD

=======
	List<Rental> getByUser_Id(int userId);
>>>>>>> 0c5ff147c80b8dab99d581804345fd061ac9f261
}
