package kodluyoruz.librarysystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","book"})
@Table(name = "rentals")
public class Rental {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Alış tarihi boş bırakılamaz")
    @NotBlank
    @DateTimeFormat
    @Column(name = "receive_date")
    private Date alis_tarih;

    @NotBlank
    @NotNull(message = "Teslim tarihi boş bırakılamaz")
    @DateTimeFormat
    @Column(name = "delivery_date")
    private Date teslim_tarihi;

    
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;
    
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
