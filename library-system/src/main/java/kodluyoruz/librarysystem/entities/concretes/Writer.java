package kodluyoruz.librarysystem.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "writers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class Writer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Yazar adı boş bırakılamaz")
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull(message = "Yazar soyadı boş bırakılamaz")
    @NotBlank
    @Column(name = "surname")
    private String surname;

     @JsonIgnore
    @OneToMany(mappedBy = "writer")
    private List<Book> books;


}