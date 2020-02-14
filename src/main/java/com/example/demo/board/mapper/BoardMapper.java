package com.example.demo.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.domain.FileVO;

//@Repository : 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
@Repository("com.example.demo.board.mapper.BoardMapper")
public interface BoardMapper {
	
	//게시글 개수
	public int boardCount() throws Exception;
	
	public List<BoardVO> boardList() throws Exception;
	
	public BoardVO boardDetail(int bno) throws Exception;
	
	public int boardInsert(BoardVO board) throws Exception;
	
	public int boardUpdate(BoardVO board) throws Exception;
	
	public int boardDelete(int board) throws Exception;
	
	public int fileInsert(FileVO file) throws Exception;
	
	public FileVO fileDetail(int bno) throws Exception;
	
}
