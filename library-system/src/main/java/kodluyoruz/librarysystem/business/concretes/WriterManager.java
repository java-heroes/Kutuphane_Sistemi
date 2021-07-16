package kodluyoruz.librarysystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.WriterService;
import kodluyoruz.librarysystem.dataAccess.abstracts.WriterDao;
import kodluyoruz.librarysystem.entities.concretes.Writer;

@Service
public class WriterManager implements WriterService {
    private WriterDao writerDao;
    @Autowired
    public WriterManager(WriterDao writerDao) {
        super();
        this.writerDao = writerDao;
    }

    @Override
    public List<Writer> getAll() {
        return writerDao.findAll();
    }

    @Override
    public Writer getById(int id) {
        return writerDao.getById(id);
    }

    @Override
    public void addWriter(Writer writer) {
        writerDao.save(writer);
    }

    @Override
    public void update(Writer writer) {
        writerDao.save(writer);
    }

    @Override
    public void delete(Integer id) {
        writerDao.deleteById(id);
    }

    @Override
    public Writer getByWriterName(String writerName) {
        return writerDao.getByName(writerName);
    }


}