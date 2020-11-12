package com.cardif.teste.service;

import org.springframework.stereotype.Service;

import com.cardif.teste.arquitetura.service.GenericServiceimpl;
import com.cardif.teste.model.entity.Cargo;
import com.cardif.teste.repository.CargoRepository;

@Service
public class CargoService extends GenericServiceimpl<CargoRepository, Cargo>{

}
