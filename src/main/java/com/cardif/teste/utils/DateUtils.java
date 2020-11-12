package com.cardif.teste.utils;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {
	
	public static int diferencaEmAnos(LocalDate dataMaior, LocalDate dataMenor) {
		Period intervalPeriod = Period.between(dataMenor, dataMaior);
		return intervalPeriod.getYears();
	}

}
