package org.zerock.controller.lecture.normal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex02/*")
@Log4j
public class Ex02Controller {	
	
	@RequestMapping("/sub01")
	public void method01(HttpServletRequest request) {
		log.info("ex02, sub01 method");
		log.info(request);
	}
	
	@RequestMapping("/sub02")
	public void method02(HttpServletRequest req) {
		log.info("ex02 sub02 method");
		log.info(req.getParameter("id"));
		log.info(req.getParameter("age"));
		
		// @RequestParam 어노테이션을 사용하기 전에 사용했던 방법
		String idparam = req.getParameter("id");
		log.info(idparam);
	}
	
	@RequestMapping("/sub03")
	public void method03(@RequestParam("id") String idparam) {
		log.info("ex02 sub03 method");
		log.info(idparam);
	} // @RequestParam 파라미터에 "id"라는 값이 있으면 idparam 여기에 담을 것


	
	//2개 이상의 파라미터를 가져올 때 쓰는 코드
	@RequestMapping("/sub04")
	public void method04(@RequestParam("id") String idParam,
			@RequestParam("age") String ageParam) {
		
		log.info("ex02 sub04 method");
		log.info(idParam);
		log.info(ageParam);
	} 
	
	
	
	@RequestMapping("/sub05")
	public void method05(@RequestParam String id, 
			@RequestParam String age) {
//		String id = request.getParameter("id");
//		String age = request.getParameter("age");
		
		log.info("ex02 sub05 method");
		log.info(id);
		log.info(age);
	} 
	// value와 parameter 값이 중복되는 경우, value 값은 생략가능
	// dispatcher서블릿이 알아서 찾아옴
	
	
	@RequestMapping("/sub06")
	public void method06(@RequestParam int age) {
//		int age = Integer.parseInt(request.getParameter("age"));
		
		log.info("ex02 sub06 method");
		log.info(age);
	}
	// 형변환 코드
	
	
	@RequestMapping("/sub07")
	public void method07(@RequestParam String[] fav) {
		log.info("ex02 sub07 method");
		
		for (String f : fav) {
			log.info(f);
		}
	}
	// 여러 값이 넘어올 경우, 배열 코드로 작성
	
	@RequestMapping("/sub08")
	public void method08(@RequestParam List<String> fav) {
		log.info("ex02 sub08 method");
		
		log.info(fav);
	}
	// 여러 값이 넘어올 경우, 리스트로 작성
	
}
















