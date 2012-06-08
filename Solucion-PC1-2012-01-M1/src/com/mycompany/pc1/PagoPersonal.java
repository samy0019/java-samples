package com.mycompany.pc1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PagoPersonal {



	public BigDecimal calcularPago(Periodo periodo) {
	
		BigDecimal resultado = BigDecimal.ZERO;
		
		for(Asistencia a : periodo.getAsistencias()){
			resultado = resultado.add(a.getHorasDictadas().multiply(a.getRol().getCostoPorHora())).setScale(2, RoundingMode.HALF_EVEN);
		}
		
		return resultado;
	}

}
