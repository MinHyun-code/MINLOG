package jpa.blog.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BoardLikeKey implements Serializable {
	private String board;
	private String user;	
}