package com.lab603.jpa.sample.web.bbs.dto;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

@Data

// 테이블명
@Entity(name="board")
public class BoardDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	private String type;

	private String title;

	private String contents;

	private LocalDateTime createtime;

	public BoardDTO() {}

	public BoardDTO(Long no, String type, String title, String contents, LocalDateTime createtime)
	{
		this.no = no;
		this.type = type;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
	}
}