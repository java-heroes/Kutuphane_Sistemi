package kodluyoruz.librarysystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithCategoryAndWriterDto {

	private int id;
	private String bookName;
	private String categoryName;
	private String writerName;
	
	
}
