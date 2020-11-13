package com.cardif.teste.arquitetura.controller;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cardif.teste.arquitetura.dto.IEntityDTO;


public interface IRestController {	
	public ResponseEntity<?> listAll(Pageable pageable);
	public ResponseEntity<?> showById(@PathVariable(value = "id") Long id);	
	public ResponseEntity<?> create(@RequestBody IEntityDTO object, BindingResult result);	
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody IEntityDTO object, Errors errors);	
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id);

}
