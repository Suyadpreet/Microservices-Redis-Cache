package com.suyad.models;

import java.io.Serializable;

public class Books implements Serializable
{
	private Integer bookId;
	private String bookName;
	
	public Integer getBookId() 
	{
		return bookId;
	}
	public void setBookId(Integer bookId) 
	{
		this.bookId = bookId;
	}
	public String getBookName() 
	{
		return bookName;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
}
