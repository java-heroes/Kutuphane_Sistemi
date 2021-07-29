package kodluyoruz.librarysystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.librarysystem.entities.concretes.Writer;

public interface WriterDao extends JpaRepository<Writer, Integer> {
    Writer getByName(String writerName);

    List<Writer> getById(int id);

    void deleteById(Integer id);
}
