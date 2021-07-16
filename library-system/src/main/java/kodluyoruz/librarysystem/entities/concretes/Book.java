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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","category"})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rentals"})
public class Book  {
	
	//private static final long serialVersionUID=1l;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="book_name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="barcode_no")
	private int barcode_no;
	@Column(name="publish_date")
	private Date publishDate;
	@Column(name="number_of_pages")
	private int number_of_pages;
	@Column(name="is_rent")
	private boolean isRent;
	@JsonIgnoreProperties({"books"})
	@ManyToOne()
	@JoinColumn(name="category_id")
	Category category;
	
	@ManyToOne()
	@JoinColumn(name="writer_id")
	Writer writer;
	
	@OneToMany(mappedBy="book")
	private List<Rental> rentals;
}
