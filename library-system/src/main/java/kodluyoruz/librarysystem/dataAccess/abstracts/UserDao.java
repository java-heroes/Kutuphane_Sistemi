package kodluyoruz.librarysystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
