package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

//	페이징
	private int pageNum;
	private int amount;
	
//	검색
	private String type;
	private String keyword;

	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getFrom() {
		return amount * (pageNum - 1);
	}
	
	public String[] getTypeArr() {
//		type.split("");
//		split : () 괄호 안의 값을 구분자로 사용해 배열을 각각의 스트링으로 구분하겠다는 메소드 
//				이후 구분된 값을 배열로 나열할 것	
		
		if (type == null) {
			return new String[] {};
//			type이 null 값인 경우 빈 string 배열을 리턴할 것
		} else {
			String[] types = type.split("");
			return types;
//			split으로 구분한 배열들을 리턴할 것
		}	
	}
	
}