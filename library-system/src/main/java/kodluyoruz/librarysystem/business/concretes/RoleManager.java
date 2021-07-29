package kodluyoruz.librarysystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.RoleService;
import kodluyoruz.librarysystem.dataAccess.abstracts.RoleDao;
import kodluyoruz.librarysystem.entities.concretes.Role;

@Service(value = "roleService")
public class RoleManager implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}