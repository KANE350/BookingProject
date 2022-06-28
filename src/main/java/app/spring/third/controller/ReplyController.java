package app.spring.third.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





import app.spring.third.dto.Reply;
import app.spring.third.service.ReplyService;

@RestController

@RequestMapping("reply")
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	
	//값 자체를 리턴
	@PostMapping("/")
	public String add(@RequestBody Reply reply,HttpServletRequest request ) {
		
		replyService.insert(reply);
		return "add success!";
	}
	
	//댓글의 리스트
	@GetMapping("list/{board_idx}")
	public List<Reply> list(@PathVariable int board_idx) {
		List<Reply> rlist = replyService.selectList(board_idx);
		System.out.println(rlist);
		
		return rlist;
	}
	
	
	//댓글삭제
	
		@DeleteMapping("{reply_idx}")
		public String remove (@PathVariable int reply_idx) {
			replyService.delete(reply_idx);
			return "remove ok!";
		}
		
		//댓글수정
		
		@PutMapping("/")
		public String modify (@RequestBody Reply reply, HttpServletRequest request) {
			
			
			replyService.update(reply);
			return "modify ok!";
		}
		
	
	
}
