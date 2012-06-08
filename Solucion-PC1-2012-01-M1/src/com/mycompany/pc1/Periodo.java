package com.mycompany.pc1;

import java.util.List;

public class Periodo {

	private String periodo;
	private List<Asistencia> asistencias;

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
		
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
		
	}

	public String getPeriodo() {
		return periodo;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}
	
	

}
