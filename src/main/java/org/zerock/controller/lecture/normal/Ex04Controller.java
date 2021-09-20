package org.zerock.controller.lecture.normal;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex04/*")
@Log4j
public class Ex04Controller {

	// http://localhost:8080/controller/ex04/sub01?date=2020-01-01
	@RequestMapping("/sub01")
	public void method01(@RequestParam String date) {
		log.info("ex04, sub01 method");
		
		log.info(date);
	}
	
	// http://localhost:8080/controller/ex04/sub02?date=2020-01-01
	@RequestMapping("/sub02")
	public void method02(@RequestParam Date date) {
		log.info("ex04, sub02 method");
		
		log.info(date);
	} 
	// @RequestParam String 타입이므로 Date로 사용 불가능
	// 변환이 필요함
	
	
	// @RequestMapping이 붙어있는 handler가 실행되기 직전에 실행됨
	@InitBinder 
	public void initBinder(WebDataBinder binder) {
		log.info("init binder");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
}


















