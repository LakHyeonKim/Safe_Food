package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.service.BoardService;
import com.ssafy.rest.service.CommentService;
import com.ssafy.rest.vo.Board;
import com.ssafy.rest.vo.Comment;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api") 
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Api(tags = {"SSAFY FOOD QNA HRM"}, description="SSAFY FOOD QNA HRM resource API")

public class QnAController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/findAllBoard")
	public ResponseEntity<List<Board>> findAllBoard() throws Exception{
		List<Board> boards = boardService.findAllBoard();
		if(boards.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(boards, HttpStatus.OK);
	}
	
	@GetMapping("/findByNo/{no}")
	public ResponseEntity<Comment> findByNo(@PathVariable int no) throws Exception{
		List<Comment> comment = boardService.findByNo(no);
		if(comment == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(comment, HttpStatus.OK);
	}
	@GetMapping("/findBoardByNo/{no}")
	public ResponseEntity<Comment> findBoardByNo(@PathVariable int no) throws Exception{
		System.out.println();
		Board board = boardService.findBoardByNo(no);
		if(board == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(board, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Board> findById(@PathVariable String id) throws Exception{
		Board board = boardService.findById(id);
		if(board == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(board, HttpStatus.OK);
	}
	
	@GetMapping("/findByContents/{contents}")
	public ResponseEntity<List<Board>> findByContents(@PathVariable String contents) throws Exception{
		List<Board> boards = boardService.findByContents(contents);
		if(boards.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(boards, HttpStatus.OK);
	}
	
	@PostMapping("/addBoard")
	public ResponseEntity addBoard(@RequestBody Board board) throws Exception{
		boolean result = boardService.addBoard(board);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@PutMapping("/updateBoard")
	public ResponseEntity updateBoard(@RequestBody Board board) throws Exception{
		boolean result =  boardService.updateBoard(board);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBoard/{no}")
	public ResponseEntity deleteBoard(@PathVariable int no) throws Exception{
		boolean result = boardService.deleteBoard(no);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@PostMapping("/addComment")
	public ResponseEntity addComment(@RequestBody Comment comment) throws Exception{
		System.out.println(comment);
		boolean result = commentService.addComment(comment);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@PutMapping("/updateComment")
	public ResponseEntity updateComment(@RequestBody Comment comment) throws Exception{
		boolean result =  commentService.updateComment(comment);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteComment/{no}")
	public ResponseEntity deleteComment(@PathVariable int no) throws Exception{
		boolean result = commentService.deleteComment(no);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(true, HttpStatus.OK);
	}
	
}
