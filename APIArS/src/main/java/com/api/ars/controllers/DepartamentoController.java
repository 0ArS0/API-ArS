package com.api.ars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ars.dto.DepartamentoDTO;
import com.api.ars.entities.Departamento;
import com.api.ars.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping("/buscar/{id}")
	public DepartamentoDTO buscarPorId(@PathVariable Integer id) {
		return departamentoService.buscarPorId(id);
	}
	
	@GetMapping("/listar")
	public List<DepartamentoDTO> listarTodos() {
		return departamentoService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody DepartamentoDTO departamentoDTO) {
		return departamentoService.salvar(departamentoDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public DepartamentoDTO atualizar(@PathVariable Integer id, @RequestBody DepartamentoDTO departamentoDTO) {
		return departamentoService.atualizar(id, departamentoDTO);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		departamentoService.removerLogico(id);
	}
}
