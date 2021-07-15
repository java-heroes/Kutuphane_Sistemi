package kodluyoruz.librarysystem.business.abstracts;

import kodluyoruz.librarysystem.entities.concretes.Book;
import kodluyoruz.librarysystem.entities.concretes.Kiralama;

import java.util.List;

public interface KiralamaService {
    public List<Kiralama> getAll();
   public Kiralama getById(int id);
  public   void addBook(Kiralama kiralama);
    public void update(Kiralama kiralama);
   public void delete(Integer id);
}
