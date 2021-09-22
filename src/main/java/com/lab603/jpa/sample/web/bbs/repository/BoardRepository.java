package com.lab603.jpa.sample.web.bbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lab603.jpa.sample.web.bbs.dto.BoardDTO;

@Repository
public interface BoardRepository extends JpaRepository<BoardDTO, Long>
{
	public List<BoardDTO> findByNo(String no);
}
