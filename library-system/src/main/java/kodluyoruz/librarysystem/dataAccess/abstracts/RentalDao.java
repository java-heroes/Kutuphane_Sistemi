package kodluyoruz.librarysystem.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental,Integer> {
}
