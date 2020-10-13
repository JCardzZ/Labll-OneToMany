package com.mm.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.com.model.Estudiante;
import com.mm.com.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public List<Estudiante> getAllStudents() {
		return estudianteRepository.findAll();
	}

	@Override
	public void saveStudents(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
	}

	@Override
	public Estudiante getStudentById(long id) {
		Optional<Estudiante> optional = estudianteRepository.findById(id);
		Estudiante estudiante = null;
		if (optional.isPresent()) {
			estudiante = optional.get();

		} else {
			throw new RuntimeException("Estudiante no encontrado con id: " + id);
		}
		return estudiante;
	}

	@Override
	public void deleteStudentsById(long id) {
		estudianteRepository.deleteById(id);
	}

}
