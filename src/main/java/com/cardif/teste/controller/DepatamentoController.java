package com.cardif.teste.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardif.teste.arquitetura.controller.AbstractRestController;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.service.DepartamentoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/departamentos")
@Api(tags = "Departamentos")
public class DepatamentoController extends AbstractRestController<Departamento, DepartamentoService>{
}
