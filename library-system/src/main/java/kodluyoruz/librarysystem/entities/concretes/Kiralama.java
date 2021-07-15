//package kodluyoruz.librarysystem.entities.concretes;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name="kiralama")
//public class Kiralama {
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name="user_name")
//    private Integer  kullanici_Adi;
//
//    @Column(name="book_name")
//    private Integer  kitap_adi;
//
//    @Column(name="receive_name")
//    private Date alis_tarih;
//
//    @Column(name="delivery_date")
//    private Date teslim_tarihi;
//
//    @ManyToOne()
//    @JoinColumn(name="userName")
//    private Book books;
//
//}
