package kodluyoruz.librarysystem.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","category"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "rentals"})
public class Book {


    //validation için,
    //@Size(min=2, max=30)
    //@Email
    //   @NotNull
    //   @NotBlank
    //@Pattern(regexp ="[0-9\\s]{12}") telefon için kullan

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    @NotNull(message = "kitap adı boş bırakılamaz")
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotNull(message = "açıklama boş bırakılamaz")
    @NotBlank
    @Column(name = "description")
    private String description;
    @Column(name = "barcode_no")
    @NotNull(message = "barkod no boş bırakılamaz")
    private int barcode_no;
    @Column(name = "publish_date")
    private Date publishDate;
    @Min(value = 50, message = "kitap sayfası 50 den az olamaz.")
    @Column(name = "number_of_pages")
    private int number_of_pages;
    @Column(name = "is_rent")
    private boolean isRent;

    @Column(name = "rent_num")
    private int rentNum;

    @JsonIgnoreProperties({"books"})
    @ManyToOne()
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne()
    @JoinColumn(name = "writer_id")
    Writer writer;
   
    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<Rental> rentals;
}
