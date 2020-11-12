package com.cardif.teste;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import com.cardif.teste.model.entity.Funcionario;

@SpringBootTest
class TesteCardifApplicationTests {

	@Test
	void contextLoads() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNomeFuncionario("Anderson Oliveira");
		funcionario.setDataNascFuncionario(LocalDate.parse("1982-10-11"));
		
		Assertions.assertEquals(38, funcionario.getIdadeFuncionario());
	}

}
