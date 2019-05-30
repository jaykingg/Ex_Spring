package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/board/*") 
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	/*
	 * GetMapping : 해당 URL로 값을 "받아" 처리
	 * PostMapping : 해당 URL로 값을 "보내서" 처리
	 */
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		/* RedirectAttributes : 등록 작업 후 목록 화면으로 이동하기 위함. */
		log.info("register : " + board);
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		/* redirect: -> response.sendRedirect()를 springMVC가 내부적으로 처리 */
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/get")
	/* bno의 명시적 처리  */
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bno));
		
	}
	
	/*/modify URL로 접근했을 때,함수 내용을 가지고 /board/list 로 리턴한다. */
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modifyy : " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "sucess");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	
}
