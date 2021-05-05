package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.PagesReadRepository;
import com.act.entity.PagesRead;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagesReadService {

	@Autowired
	private PagesReadRepository pagesReadRepository;
	
	public List<PagesRead> getAllPagesRead(){
		
		List<PagesRead> pages = pagesReadRepository.findAll();
	
		return pages == null ? Collections.emptyList() : pages;
	}
	
	public PagesRead getPagesReadById(int pagesReadId) {
		
		Optional<PagesRead> pagesInstance = pagesReadRepository.findById(pagesReadId);
		
		return pagesInstance.orElse(null);
	}
	
	public PagesRead saveNewPagesRead(PagesRead pagesRead) {
		pagesRead.setId(0);
		return pagesReadRepository.save(pagesRead);
	}
	
	public PagesRead updatePagesRead(PagesRead pagesRead) {
		return pagesReadRepository.save(pagesRead);
	}
	
	private String ifPagesReadDelete(PagesRead pagesRead) {
		String response = "Pages Read ";
		
		if(pagesRead == null) {
			response += "Not Found!!!";
		} else {
			response += " with id: " + pagesRead.getId();
			pagesReadRepository.deleteById(pagesRead.getId());
			response += " Deleted...";
		}
		return response;
	}
	
	public String deletePagesRead(int pagesReadId) {
			
		Optional<PagesRead> pagesReadInstance = pagesReadRepository.findById(pagesReadId);
		
		return this.ifPagesReadDelete(pagesReadInstance.orElse(null));
	}	
}
