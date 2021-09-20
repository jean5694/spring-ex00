package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {

	private BoardService service;


//	 @Autowired 
//	  public BoardController(BoardService service) { 
//		 this.service = service; 
//	  }
	 
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("board/list method.....");
		int total = service.getTotal(cri); // 총 게시글 갯수 구하기
		
		
		// service getList() 실행 결과를
		List<BoardVO> list = service.getList(cri);
		// model에 attribute로 넣고
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		
		// view로 포워드
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		// service에게 등록업무 시키고
		service.register(board); // title, content, writer

		// redirect목적지로 정보 전달
		rttr.addFlashAttribute("result", board.getBno());
		rttr.addFlashAttribute("messageTitle", "등록 성공");
		rttr.addFlashAttribute("messageBody", board.getBno() + "번 게시물이 등록 되었습니다.");

		// /board/list redirect
		return "redirect:/board/list";
	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, 
			@ModelAttribute("cri") Criteria cri, 
			Model model) {
		log.info("board/get method");

		// service에게 일 시킴
		BoardVO vo = service.get(bno);

		// 결과를 모델에 넣음
		model.addAttribute("board", vo);

		// forward
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		// request parameter 수집

		// service 일 시킴
		boolean success = service.modify(board);

		// 리다이렉트에 결과를 addFlashAttribute로 모델(또는 FlashMap)에 담아 리다이렉트 진행
		if (success) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messageTitle", "수정 완료");
			rttr.addFlashAttribute("messageBody", "작성한 게시물이 수정되었습니다.");
		}

		// 리다이렉트 뒤에 쿼리스트링으로 붙일 때는 addAttribute 사용
		rttr.addAttribute("pageNum", cri.getPageNum()); // pageNum이란 이름으로 cri.getPageNum()값 넣기
		rttr.addAttribute("amount", cri.getAmount());
		// 게시물 수정 이후에도 검색 조회내역을 유지하기 위해 설정
		rttr.addAttribute("type", cri.getType()); 
		rttr.addAttribute("keyword", cri.getKeyword());		
		
		// forward or redirect
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
		// parameter 수집

		// service 일
		boolean success = service.remove(bno);
		// 결과 담고
		if (success) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messageTitle", "삭제 완료");
			rttr.addFlashAttribute("messageBody", "작성한 게시물이 삭제되었습니다.");
		}

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		// forward or redirect
		return "redirect:/board/list";

	}

	// cri 파라미터 값을 넣어 페이지에 대한 값을 입력해주기
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri) {
		// forward /WEB-INF/views/board/register.jsp
	}
}