package com.mm.com.service;

import java.util.List;

import com.mm.com.model.Estudiante;

public interface EstudianteService {

	List<Estudiante> getAllStudents();
	void saveStudents(Estudiante estudiante);
	Estudiante getStudentById(long id);
	void deleteStudentsById(long id);
}
