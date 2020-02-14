package com.example.demo.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.domain.CommentVO;
import com.example.demo.board.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource(name="com.example.demo.board.service.CommentService")
	CommentService mCommentService;
	
	@RequestMapping("/list")
	@ResponseBody
	private List<CommentVO> mCommentServiceList(Model model) throws Exception {
		return mCommentService.commentListService();
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	private int mCommnetServiceInsert(@RequestParam int bno, @RequestParam String content) throws Exception {
		
		CommentVO comment = new CommentVO();
		comment.setBno(bno);
		comment.setContent(content);
		
		//로그인 기능을 구현했거나 따로 댓글 작성자를 받는 폼이 있다면 입력 받아온 값 적용
		comment.setWriter("test");
		
		return mCommentService.commentInsertService(comment);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	private int mCommentServiceUpdateProc(@RequestParam int cno, @RequestParam String content) throws Exception {
		
		CommentVO comment = new CommentVO();
		comment.setCno(cno);
		comment.setContent(content);
		
		return mCommentService.commentUpdateService(comment);
	}
	
	@RequestMapping("/delete/{cno}")
	@ResponseBody
	private int mCommentServiceDelete(@PathVariable int cno) throws Exception {
		return mCommentService.commentDeleteService(cno);
	}

}
