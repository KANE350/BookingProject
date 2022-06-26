package app.spring.third.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Page;
import app.spring.third.dto.ReviewBoard;
import app.spring.third.dto.Reviewfile;
import app.spring.third.service.RboardService;
import app.spring.third.service.ReviewfileService;

@Controller
@RequestMapping("review")
//@SessionAttributes("page")
public class RboardController {
	@Autowired
	private RboardService rboardService;
	
	@Autowired
	private ReviewfileService reviewfileService;
	
	@GetMapping("/")
public String listhome(Page page, Model model) { //2)page객체 생성
		
		//세션에 객체를 할당하기 위한 목적
		model.addAttribute("page",page); //3)할당
		
		return "redirect:/reviewlist";
	}
	
	@GetMapping("reviewlist")
	public String reviewlist(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("rvlist", rboardService.selectlist(page));
		
		return "review/reviewlist";
		
		
	}
	
	
	//추가페이지 이동
		@GetMapping("reviewAdd")
		public void add() {
			
		}
		
		//추가
		@PostMapping("reviewAdd")
		public String add(ReviewBoard reviewboard,HttpServletRequest request,RedirectAttributes rattr) throws Exception {
			
			ErrorCode errorCode = rboardService.insert(reviewboard);
			
			//리스트이동
			rattr.addFlashAttribute("msg",errorCode.getMsg());
			
			return "redirect:/review/reviewlist";
		}
		
		
		//상세페이지 이동
		@GetMapping("reviewdetail")
		public void reviewdetail(@RequestParam int board_idx,Model model) {
			
			
			//조회수 +1 
			rboardService.update_readcnt(board_idx);
			
			
			//게시물
			ReviewBoard reviewBoard = rboardService.selectOne(board_idx);
			
			//게시물 파일들 조회
			
			List<Reviewfile> rflist = reviewfileService.selectList(board_idx);
			model.addAttribute("rflist",rflist);
			
			
			
			model.addAttribute("reviewBoard",reviewBoard);
			
			
		
		}
		
		//삭제
		@GetMapping("reviewRemove")
		public String delete(@RequestParam int board_idx,RedirectAttributes rattr) {
			
			
			//서비스 불러서 삭제
			ErrorCode errorCode = rboardService.delete(board_idx);
			rattr.addFlashAttribute("msg","삭제완료");
			
			
			return "redirect:/review/reviewlist";
		}
		
		//수정
		@GetMapping("reviewModify")
		public void update(@RequestParam int board_idx,Model model) {
			//게시물 조회 
			ReviewBoard rboard = rboardService.selectOne(board_idx);
			model.addAttribute("rboard",rboard);
			
			
			//게시물 파일 조회
			List<Reviewfile> reviewFile = reviewfileService.selectList(board_idx);
			model.addAttribute("reviewFile",reviewFile);
			
			// board/modify.jsp로 이동
			
		}
		
		//수정버튼 클릭했을때
		@PostMapping("reviewModify")
		public String modify(ReviewBoard reviewboard,
					@RequestParam(required=false) List<Integer> removeFiles,
					HttpServletRequest request,
					RedirectAttributes rattr) throws Exception {
			System.out.println(removeFiles);
			
			ErrorCode errorCode = rboardService.update(reviewboard, removeFiles);
			
			//디테일로 이동
			
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			rattr.addAttribute("board_idx",reviewboard.getBoard_idx());
			
			return "redirect:reviewdetail";
			
		}
		
		//좋아요 +1
		@ResponseBody
		@PutMapping("like/{board_idx}")
		public String likecnt(@PathVariable int board_idx) {
			rboardService.updateLikeCnt(board_idx);
			ReviewBoard reviewboard = rboardService.selectOne(board_idx);
			//좋아요를 문자로 변경후 리턴
			return String.valueOf(reviewboard.getBoard_likes());
		}
		
		
	
}
