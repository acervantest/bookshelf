package com.act.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.entity.PagesRead;
import com.act.service.PagesReadService;

@RestController
@RequestMapping("/api")
public class PagesReadController {

	@Autowired
	private PagesReadService pagesReadService;
	
	@GetMapping("/pages")
	public List<PagesRead> findAllPagesRead() {
		return pagesReadService.getAllPagesRead();
	}
	
	@GetMapping("/pages/{pagesReadId}")
	public PagesRead findPagesReadById(@PathVariable int pagesReadId) {
		return pagesReadService.getPagesReadById(pagesReadId);
	}
	
	@PostMapping("/pages")
	public PagesRead addPagesRead(@RequestBody PagesRead pagesRead) {
		return pagesReadService.saveNewPagesRead(pagesRead);
	}
	
	@PutMapping("/pages")
	public PagesRead updatePagesRead(@RequestBody PagesRead pagesRead) {
		return pagesReadService.updatePagesRead(pagesRead);
	}
	
	@DeleteMapping("/pages/{pagesReadId}")
	public String deletePagesRead(@PathVariable int pagesReadId) {		
		return pagesReadService.deletePagesRead(pagesReadId);
	}
}