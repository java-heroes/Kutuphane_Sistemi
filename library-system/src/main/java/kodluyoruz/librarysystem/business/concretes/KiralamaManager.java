//package kodluyoruz.librarysystem.business.concretes;
//
//import kodluyoruz.librarysystem.business.abstracts.KiralamaService;
//import kodluyoruz.librarysystem.dataAccess.abstracts.KiralamaDao;
//import kodluyoruz.librarysystem.entities.concretes.Kiralama;
//import kodluyoruz.librarysystem.exception.IdNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class KiralamaManager implements KiralamaService {
//    private KiralamaDao kiralamaDao;
//    @Autowired
//    public KiralamaManager(KiralamaDao kiralamaDao) {
//        super();
//        this.kiralamaDao = kiralamaDao;
//    }
//
//
//    @Override
//    public List<Kiralama> getAll() {
//        return kiralamaDao.findAll();
//    }
//
//    @Override
//    public Kiralama getById(Integer id) {
//        if(id!=null){
//        return kiralamaDao.getById(id);}
//        else
//            throw new IdNotFoundException(id);
//    }
//
//    @Override
//    public void KiralamaYap(Kiralama kiralama) {
//        kiralamaDao.save(kiralama);
//    }
//
//    @Override
//    public void update(Kiralama kiralama) {
//        kiralamaDao.save(kiralama);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        kiralamaDao.deleteById(id);
//    }
//}
