package com.cardif.teste.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardif.teste.arquitetura.controller.AbstractRestController;
import com.cardif.teste.model.entity.Cargo;
import com.cardif.teste.service.CargoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/cargos")
@Api(tags = "Cargos")
public class CargoController extends AbstractRestController<Cargo, CargoService>{

}
