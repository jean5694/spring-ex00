package org.zerock.controller.lecture;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex07/*")
@Log4j
public class Ex07Controller {
	
	//리턴되는 스트링 자체가 응답이 되도록 하는 방식
	
	@RequestMapping("/sub01")
	public @ResponseBody String method01() {
		log.info("ex07, sub01 method");
		
		return "my response message!!!!!!!";
		
	}
	
	// 객체 정보 자체를 리턴하는 경우
	@RequestMapping("/sub02")
	public @ResponseBody String method02() {
		log.info("ex07, sub02 method");
		
		User user = new User();
		user.setId("donald");
		user.setAge(99);
		
		return user.toString();
	}
	
	//JSON 작성방식 코드
	@RequestMapping("/sub03")
	public @ResponseBody String method03() {
		log.info("ex07, sub03 method");
		
		User user = new User();
		user.setId("donald");
		user.setAge(99);
		
		return "{\"id\":" + "\"" + user.getId() + "\", " + "\"age\":" + user.getAge() + "}";
	}
	
	// 라이브러리를 통해 JSON 타입으로 객체를 변환해서 전달함
	@RequestMapping("/sub04")
	public @ResponseBody User method04() {
		log.info("ex07, sub04 method");
		
		User user = new User();
		user.setId("trump");
		user.setAge(88);
		
		return user;
	}
	

	// ResponseEntity<String> entity 가 가지고 있는것
	// 본문과 헤더 정보를 동시에 넘기고 싶을 때
	// 상태 코드,값
	// 부가정보(header)
	// 본문(body)
	@RequestMapping("/sub05")
	public ResponseEntity<String> method05() {
		log.info("ex07, sub05 method");
		
		// 부가정보
		HttpHeaders headers = new HttpHeaders(); 
		headers.add("Content-Type", "text/html; charset=utf-8");
		headers.add("my-header", "my-value");
		
		// 본문
		String body = "<h1>Hello Entity</h1>"; 
		
		return new ResponseEntity<String>(body, headers, HttpStatus.OK); // (본문, 부가정보, 상태코드)
	}
}
















