package com.mycompany.pc1;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersonalTest {

	
	Persona p;
	Rol r1;
	Rol r2;
	Periodo periodo1;
	Curso c1;
	Horario h1;
	Horario h2;
	
	PagoPersonal pagoPersonal;
	
	@Before
	public void inicio(){
		
		
		//preparacion de la prueba
		p = new Persona();
		p.setNombre("Jose Diaz");
		p.setDni("25723525");
		p.setEmail("jamdiazdiaz@gmail.com");
		p.setCiu("12345");
		
		
		r1 = new Rol("Docente", new BigDecimal(60.00));
		r2 = new Rol("Tutor", new BigDecimal(16.50));
		

		
		periodo1  = new Periodo();
		periodo1.setPeriodo("2012-06");

		c1 = new Curso();
		c1.setNombre("Programacion Orientada a Objetos");

		
		h1 = new Horario();
		h1.setPeriodo(periodo1);
		h1.setCurso(c1);
		h1.setHoraInicio("7:00pm");
		h1.setHoraFin("10:00pm");
		h1.setCodigo("A31A");		
		
		h2 = new Horario();
		h2.setPeriodo(periodo1);
		h2.setCurso(c1);
		h2.setHoraInicio("7:00pm");
		h2.setHoraFin("10:00pm");
		h2.setCodigo("C31B");			
	}
	
	
	@Test
	public void deberiaCalcularNumeroDeHorasSiSoloHaTrabajadoComoDocente(){
		
		Asistencia a1 = new Asistencia(periodo1, h1, "04/06/2012", p, r1, new BigDecimal(3));

		Asistencia a2 = new Asistencia(periodo1, h1, "11/06/2012", p, r1, new BigDecimal(3));
		
		Asistencia a3 = new Asistencia(periodo1, h1, "18/06/2012", p, r1, new BigDecimal(3));
		
		List<Asistencia> asistencias = new ArrayList<Asistencia>();
		asistencias.add(a1);
		asistencias.add(a2);
		asistencias.add(a3);
		
		periodo1.setAsistencias(asistencias);
		
		
		//ejecucion
		pagoPersonal = new PagoPersonal();
		 
		
		
		//verificacion
		assertEquals(540.00, pagoPersonal.calcularPago(periodo1).doubleValue(), 0);
		
	}
	
	@Test
	public void deberiaCalcularNumeroDeHorasSiHaTrabajadoComoDocenteYTutor(){
		


		
	
		Asistencia a1 = new Asistencia(periodo1, h1, "04/06/2012", p, r1, new BigDecimal(3));

		
		Asistencia a2 = new Asistencia(periodo1, h1, "11/06/2012", p, r2, new BigDecimal(3));
		
		
		List<Asistencia> asistencias = new ArrayList<Asistencia>();
		asistencias.add(a1);
		asistencias.add(a2);
		
		periodo1.setAsistencias(asistencias);
		
		//ejecucion
		pagoPersonal = new PagoPersonal();

		
		
		//verificacion
		assertEquals(229.50, pagoPersonal.calcularPago(periodo1).doubleValue(), 0);
		
	}	
}
