package kodluyoruz.librarysystem.business.concretes;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Business.BusinessRules;
import kodluyoruz.librarysystem.core.utilities.Results.*;
import kodluyoruz.librarysystem.entities.concretes.Book;
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
    public DataResult<List<Writer>> getAll() {
        return new SuccessDataResult<List<Writer>>(writerDao.findAll(),"Yazarlar Listelendi");
    }

    @Override
    public DataResult<List<Writer>>getById(int id) {
        return new SuccessDataResult<List<Writer>>(writerDao.getById(id));
    }

    @Override
    public Result addWriter(Writer writer) {
        Result result = BusinessRules.Run(
                CheckIfNameExist(writer.getName()));
        if (result != null) {
            return result;
        }
        writerDao.save(writer);
        return new SuccessDataResult("Yazar Başarılı bir şekilde eklendi");
    }

    public Result NullControl(Writer writer) {
        if (writer.getName() == null
                || writer.getSurname()==null) {
            return new ErrorResult("Tüm alanları doldurup tekrar deneyin");
        }
        return new SuccessResult();
    }

    public Result CheckIfNameExist(String name) {
        List<Writer> writers = writerDao.findAll();
        for (Writer writer : writers) {
            if (writer.getName().equals(name)) {
                return new ErrorResult("Yazar zaten var!");
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result update(Writer writer) {
        writerDao.save(writer);
        return new SuccessResult("Yazar guncellendi.");
    }

    @Override
    public Result delete(Integer id) {
        String writer = writerDao.getById(id).getName();
        writerDao.deleteById(id);
        return new SuccessResult(writer+" adlı yazar silindi");
    }

    @Override
    public DataResult<Writer> getByWriterName(String writerName) {
        return new SuccessDataResult<Writer>( writerDao.getByName(writerName),writerName+" 'in kitap listesi");
    }


}