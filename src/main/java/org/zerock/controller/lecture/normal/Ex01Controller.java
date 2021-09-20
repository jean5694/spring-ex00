package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller //컨트롤러임을 명시, component 포함되어 있음
@RequestMapping("/ex01/*") //url 경로 설정 
@Log4j // 롬복
public class Ex01Controller {

	@RequestMapping("/sub01") // → /ex01/sub01 경로로 오게 되면 실행되는 메소드
	public void method01() {
//		System.out.println("ex01, sub01 method");
		log.info("ex01, sub01 method");
	}

	// servlet에선 다른 경로로 일을 하게 하고 싶을 땐 파일을 새로 만들었지만
	// spring에선 하나의 컨트롤러 파일 내에서 다른 메소드를 추가 후,
	// @RequestMapping 어노테이션으로 경로 관리를 해줄 수 있다 (서블릿을 여러 개 만들 필요가 없음)
	
	@RequestMapping("/sub02") // → /ex01/sub02 경로로 오게 되면 실행되는 메소드
	public void method02() {
		log.info("ex01, sub02 method");
	}

	// 특정 메소드만 요청 처리해줄 땐 method =RequestMethod.GET/POST 를 사용함
	@RequestMapping(value = "/sub03", method = RequestMethod.GET) // 주소창에 바로 입력해서 확인 가능
	public void method03() {
		log.info("ex01, sub03 get method");
	}

	// jsp 파일이 필요함 (form action 경로 설정, submit)
	// controller/jsp/ex01.jsp url로 들어가 submit 액션을 취해야 메소드가 실행 됨
	@RequestMapping(value = "/sub03", method = RequestMethod.POST) 
	public void method04() {
		log.info("ex01, sub03 post method");
	}

	// RequestMapping GET 방식을 좀더 축약시킨 어노테이션
	@GetMapping("/sub05")
	public void method05() {
		log.info("ex01, sub05 get method");
	}
	
	// RequestMapping POST 방식을 좀더 축약시킨 어노테이션
	@PostMapping("/sub06")
	public void method06() {
		log.info("ex01, sub06 post method");
	}
}















