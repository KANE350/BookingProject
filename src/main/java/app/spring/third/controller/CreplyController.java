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


import app.spring.third.dto.ComuReply;
import app.spring.third.service.CreplyService;


@RestController

@RequestMapping("comureply")
public class CreplyController {
	@Autowired
	private CreplyService creplyService;
	
	
	//값 자체를 리턴
	@PostMapping("/")
	public String add(@RequestBody ComuReply creply,HttpServletRequest request ) {
		
		creplyService.insert(creply);
		return "add success!";
	}
	
	//댓글의 리스트
	@GetMapping("list/{cboard_idx}")
	public List<ComuReply> list(@PathVariable int cboard_idx) {
		List<ComuReply> crlist = creplyService.selectList(cboard_idx);
		System.out.println(crlist);
		
		return crlist;
	}
	
	
	//댓글삭제
	
		@DeleteMapping("{creply_idx}")
		public String remove (@PathVariable int creply_idx) {
			creplyService.delete(creply_idx);
			return "remove ok!";
		}
		
		//댓글수정
		
		@PutMapping("/")
		public String modify (@RequestBody ComuReply creply, HttpServletRequest request) {
			
			
			creplyService.update(creply);
			return "modify ok!";
		}
		
	
	
}
