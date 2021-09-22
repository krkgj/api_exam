package com.lab603.jpa.sample.web.bbs.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab603.jpa.sample.web.bbs.dto.BoardDTO;
import com.lab603.jpa.sample.web.bbs.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardBiz
{
	private final BoardRepository boardRepository;

	public List<BoardDTO> findAll()
	{
		List<BoardDTO> board = new ArrayList<>();

		boardRepository.findAll().forEach(e -> board.add(e));

		return board;
	}

	public Optional<BoardDTO> findByNo(Long no)
	{
		Optional<BoardDTO> board = boardRepository.findById(no);

		return board;
	}

	public void deleteByNo(Long no)
	{
		boardRepository.deleteById(no);
	}

	public BoardDTO save(BoardDTO board)
	{
		boardRepository.save(board);

		return board;
	}

	public void updateById(Long no, BoardDTO board)
	{
		Optional<BoardDTO> e = boardRepository.findById(no);

		if(e.isPresent())
		{
			e.get().setTitle(board.getTitle());
			e.get().setContents(board.getContents());

			boardRepository.save(board);
		}

	}
}
