package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.Writer;

public interface WriterService {
    DataResult<List<Writer>> getAll();

    DataResult<List<Writer>> getById(int id);

    Result addWriter(Writer writer);

    Result update(Writer writer);

    Result delete(Integer id);

    DataResult<Writer> getByWriterName(String writerName);
}