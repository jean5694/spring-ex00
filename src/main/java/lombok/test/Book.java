package lombok.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//모든 필드에 해당하는 메소드 적용 가능
@Getter 
@Setter
@AllArgsConstructor //생성자를 만들겠다
@NoArgsConstructor //파라미터가 없는 생성자
public class Book {
	
	@Getter
	private String title;
	private double price;
	
}
