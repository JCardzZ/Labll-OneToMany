package com.mm.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mm.com.model.Estudiante;
import com.mm.com.service.EstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listaEstudiantes", estudianteService.getAllStudents());
		return "index";
	}

	@GetMapping("/nuevoEstudiante")
	public String nuevoEstudiante(Model model) {
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante", estudiante);
		return "newStudent";
	}

	@PostMapping("/guardarEstudiante")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		estudianteService.saveStudents(estudiante);
		return "redirect:/";
	}

	@GetMapping("/actualizarEstudiante/{id}")
	public String actualizarEstudiante(@PathVariable(value = "id") long id, Model model) {
		Estudiante estudiante = estudianteService.getStudentById(id);
		model.addAttribute("estudiante", estudiante);
		return "updateStudent";
	}

	@GetMapping("/eliminarEstudiante/{id}")
	public String eliminarEstudiante(@PathVariable(value = "id") long id) {
		estudianteService.deleteStudentsById(id);
		return "redirect:/";

	}
}
