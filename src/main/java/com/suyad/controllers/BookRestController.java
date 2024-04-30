package com.suyad.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suyad.models.Books;

@RestController
public class BookRestController 
{
	HashOperations<String,Integer,Books> opsForHash=null;
	
	public BookRestController(RedisTemplate<String,Books> redisTemplate)
	{
		opsForHash = redisTemplate.opsForHash();
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@RequestBody Books b)
	{
		opsForHash.put("Books", b.getBookId(), b);
		
		return new ResponseEntity<String>("Book Saved",HttpStatus.CREATED);
	}
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Books> getBook(@PathVariable("id") Integer id)
	{
		Books books = opsForHash.get("Books", id);
		
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	@GetMapping("/allBooks")
	public ResponseEntity<Collection<Books>> getAllBooks()
	{
		Map<Integer,Books> entries = opsForHash.entries("Books");
		Collection<Books> values = entries.values();
		
		return new ResponseEntity<>(values,HttpStatus.OK);
	}
}
