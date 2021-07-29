package kodluyoruz.librarysystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
