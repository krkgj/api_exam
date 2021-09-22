package com.lab603.jpa.sample.web.bbs.act;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Optional;

import com.lab603.jpa.sample.web.bbs.biz.BoardBiz;
import com.lab603.jpa.sample.web.bbs.dto.BoardDTO;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiAct
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final BoardBiz biz;

	@ApiOperation(value = "게시판 목록")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<List<BoardDTO>> getAllBoard()
	{
		List<BoardDTO> board = biz.findAll();

		for (BoardDTO boardDTO : board)
		{
			logger.debug(boardDTO.toString());
		}

		return new ResponseEntity<List<BoardDTO>>(board, HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 조회")
	@GetMapping(value ="/{no}",  produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<BoardDTO> getBoard(@PathVariable("no") Long no)
	{
		Optional<BoardDTO> board = biz.findByNo(no);

		return new ResponseEntity<BoardDTO>(board.get(), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 삭제")
	@DeleteMapping(value ="/{no}",  produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Void> deleteBoard(@PathVariable("no") Long no)
	{
		biz.deleteByNo(no);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 수정")
	@PutMapping(value ="/{no}",  produces = {MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<BoardDTO> updateMember(@PathVariable("no") Long no, BoardDTO board)
	{
		biz.updateById(no, board);

		return new ResponseEntity<BoardDTO>(board, HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 등록")
	@PostMapping
	public ResponseEntity<BoardDTO> save(BoardDTO board)
	{
		System.out.println(board);
		return new ResponseEntity<BoardDTO>(biz.save(board), HttpStatus.OK);
	}


}
