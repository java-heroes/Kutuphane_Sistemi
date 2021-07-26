package kodluyoruz.librarysystem.business.abstracts;

import kodluyoruz.librarysystem.entities.concretes.Role;

public interface RoleService {
    Role findByName(String name);
}
