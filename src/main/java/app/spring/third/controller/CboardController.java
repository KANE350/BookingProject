package app.spring.third.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.ComuBoard;
import app.spring.third.dto.Page;
import app.spring.third.service.CboardService;



@Controller
@RequestMapping("comu")
public class CboardController {
	@Autowired
	private CboardService cboardService;
	
	
	
	@GetMapping("/")
public String listhome(Page page, Model model) { //2)page객체 생성
		
		//세션에 객체를 할당하기 위한 목적
		model.addAttribute("page",page); //3)할당
		
		return "redirect:/reviewlist";
	}
	
	@GetMapping("comulist")
	public String reviewlist(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("cmlist", cboardService.selectlist(page));
		
		return "comu/comulist";
		
		
	}
	
	
	//추가페이지 이동
		@GetMapping("comuAdd")
		public void add() {
			
		}
		
		//추가
		@PostMapping("comuAdd")
		public String add(ComuBoard comuboard,HttpServletRequest request,RedirectAttributes rattr) throws Exception {
			
			ErrorCode errorCode = cboardService.insert(comuboard);
			
			//리스트이동
			rattr.addFlashAttribute("msg",errorCode.getMsg());
			
			return "redirect:/comu/comulist";
		}
		
		
		//상세페이지 이동
		@GetMapping("comudetail")
		public void comudetail(@RequestParam int cboard_idx,Model model) {
			
			
			//조회수 +1 
			cboardService.update_readcnt(cboard_idx);
			
			
			//게시물
			ComuBoard comuBoard = cboardService.selectOne(cboard_idx);
			
			
			
			
			model.addAttribute("comuBoard",comuBoard);
			
			
		
		}
		
		//삭제
		@GetMapping("comuRemove")
		public String delete(@RequestParam int cboard_idx,RedirectAttributes rattr) {
			
			
			//서비스 불러서 삭제
			ErrorCode errorCode = cboardService.delete(cboard_idx);
			rattr.addFlashAttribute("msg","삭제완료");
			
			
			return "redirect:/comu/comulist";
		}
		
		//수정
		@GetMapping("comuModify")
		public void update(@RequestParam int cboard_idx,Model model) {
			//게시물 조회 
			ComuBoard cboard = cboardService.selectOne(cboard_idx);
			model.addAttribute("cboard",cboard);
			
			
			
			
			// board/modify.jsp로 이동
			
		}
		
		//수정버튼 클릭했을때
		@PostMapping("comuModify")
		public String modify(ComuBoard comuboard,
					HttpServletRequest request,
					RedirectAttributes rattr) throws Exception {
			
			
			ErrorCode errorCode = cboardService.update(comuboard);
			System.out.println(comuboard);
			//디테일로 이동
			
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			rattr.addAttribute("cboard_idx",comuboard.getCboard_idx());
			
			return "redirect:comudetail";
			
		}
}
