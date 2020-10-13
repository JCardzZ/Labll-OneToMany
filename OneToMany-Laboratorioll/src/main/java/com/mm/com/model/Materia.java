package com.mm.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "Materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre_materia")
	private String nombreMateria;
	
	@Column(name = "requisito")
	private String requisito;
	
	@Column(name = "docente")
	private String docente;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_estudiante", nullable = false)
	    private Estudiante estudiante;
	
	
	public Materia() {
	}


	public Materia(String nombreMateria, String requisito, String docente) {
		this.nombreMateria = nombreMateria;
		this.requisito = requisito;
		this.docente = docente;
	}


	public Materia(long id, String nombreMateria, String requisito, String docente) {
		this.id = id;
		this.nombreMateria = nombreMateria;
		this.requisito = requisito;
		this.docente = docente;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombreMateria() {
		return nombreMateria;
	}


	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}


	public String getRequisito() {
		return requisito;
	}


	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}


	public String getDocente() {
		return docente;
	}


	public void setDocente(String docente) {
		this.docente = docente;
	}


	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombreMateria=" + nombreMateria + ", requisito=" + requisito + ", docente="
				+ docente + "]";
	}
	
	
}
