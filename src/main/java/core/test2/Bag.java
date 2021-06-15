package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bag") //어노테이션에 밸류 값을 설정해서 빈 이름을 완성할 수 있음
public class Bag {

	private Book book;
	
	public Bag() {
		
	}
	
	@Autowired
	public Bag(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}

	//@Autowired //자동 주입
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
