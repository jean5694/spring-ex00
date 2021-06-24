package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex03/*")
@Log4j
public class Ex03Controller {
	
	@RequestMapping("/sub01")
	public void method01(User user) {
		
		/*
		String id = request.getParameter("id");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);
		
		User user = new User();
		user.setId(id);
		user.setAge(age);
		*/
		
		log.info("ex03, sub01 method");
		log.info(user);
	}
} 

// 파라미터 값을 아규먼트에 입력해 주는 것만으로
// DispatcherServlet이 알아서 빈 객체를 생성함
// 조건 : 파라미터 명과 프로퍼티 명이 일치하는 경우
// 주석 코드만큼을 메소드 파라미터 값을 넣어주는 걸로 대체 가능

















