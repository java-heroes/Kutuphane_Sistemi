package kodluyoruz.librarysystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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

    @Column(name = "receive_date")
    private Date alis_tarih;

    @Column(name = "delivery_date")
    private Date teslim_tarihi;

    
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;
    
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
