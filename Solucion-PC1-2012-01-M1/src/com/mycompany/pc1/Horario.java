package com.mycompany.pc1;

public class Horario {

	private Curso curso;
	private String fechaInicio;
	private String fechaFin;
	private Object periodo;
	private String codigo;

	public void setCurso(Curso curso) {
		this.curso = curso;
		
	}

	public void setHoraInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
		
	}

	public void setHoraFin(String fechaFin) {
		this.fechaFin = fechaFin;
		
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
		
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
		
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Object getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Object periodo) {
		this.periodo = periodo;
	}

	public Curso getCurso() {
		return curso;
	}

	public String getCodigo() {
		return codigo;
	}
	
	

}
