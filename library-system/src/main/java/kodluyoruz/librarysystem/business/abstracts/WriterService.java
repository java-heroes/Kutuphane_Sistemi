package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.entities.concretes.Writer;

public interface WriterService {
    List<Writer> getAll();
    Writer getById(int id);
    void addWriter(Writer writer);
    void update(Writer writer);
    void delete(Integer id);
    Writer getByWriterName(String writerName);
}