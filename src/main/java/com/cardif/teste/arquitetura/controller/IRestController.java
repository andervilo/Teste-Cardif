package com.cardif.teste.arquitetura.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IRestController<E> {	
	public ResponseEntity<?> listAll(Pageable pageable);
	public ResponseEntity<?> showById(@PathVariable(value = "id") Long id);	
	public ResponseEntity<?> create(@RequestBody E object, BindingResult result);	
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody E object, Errors errors);	
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id);

}
