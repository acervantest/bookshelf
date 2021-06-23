package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.act.exceptions.NotFoundException;
import com.act.validators.ValidatorService;
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

	@Autowired
	private ValidatorService validatorService;
	
	public List<PagesRead> getAllPagesRead(){
		
		List<PagesRead> pages = pagesReadRepository.findAll();
	
		return pages == null ? Collections.emptyList() : pages;
	}
	
	public PagesRead getPagesReadById(int pagesReadId) {
		
		Optional<PagesRead> pagesInstance = pagesReadRepository.findById(pagesReadId);

		if(!pagesInstance.isPresent()) throw new NotFoundException(" PAGES READ id [ "+ pagesReadId +" ] NOT FOUND");
		
		return pagesInstance.get();
	}

	public List<PagesRead> getPagesReadByUser(int userId, int bookId){

		Optional<List<PagesRead>> pagesReadOptional = pagesReadRepository.fetchPagesReadByBookAndUser(userId, bookId);

		return pagesReadOptional.isPresent() ? pagesReadOptional.get() : null;
	}
	
	public PagesRead saveNewPagesRead(PagesRead pagesRead) {

		validatorService.validate(pagesRead, PagesRead.class);

		pagesRead.setId(0);

		return pagesReadRepository.save(pagesRead);
	}
	
	public PagesRead updatePagesRead(PagesRead pagesRead) {

		validatorService.validate(pagesRead, PagesRead.class);

		return pagesReadRepository.save(pagesRead);
	}

	public String deletePagesReadById(int pagesReadId){

		PagesRead pagesReadEntity = getPagesReadById(pagesReadId);

		pagesReadRepository.delete(pagesReadEntity);

		return "Pages Read with id [ " + pagesReadId + " ] DELETED...";
	}
}
