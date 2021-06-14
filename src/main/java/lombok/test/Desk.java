package lombok.test;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //final 필드만 받는 생성자호출 메소드
public class Desk {
	private final double price;
	private final String model;
	private String name;
	
}
