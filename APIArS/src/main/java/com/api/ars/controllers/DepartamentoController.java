package com.api.ars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ars.entities.Departamento;
import com.api.ars.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping("/buscar/{id}")
	public Departamento buscarPorId(@PathVariable Integer id) {
		return departamentoService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<Departamento> listarTodos() {
		return departamentoService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public Departamento salvar(@RequestBody Departamento departamento) {
		return departamentoService.salvar(departamento);
	}
	
	@PutMapping("/atualizar/{id}")
	public Departamento atualizar(@PathVariable Integer id, @RequestBody Departamento departamento) {
		return departamentoService.atualizar(id, departamento);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		departamentoService.removerLogico(id);
	}
}
