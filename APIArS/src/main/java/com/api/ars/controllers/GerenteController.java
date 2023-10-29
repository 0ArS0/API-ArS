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

import com.api.ars.dto.GerenteDTO;
import com.api.ars.dto.GerenteGetDTO;
import com.api.ars.services.GerenteService;


@RestController
@RequestMapping("/gerente")
public class GerenteController {

	@Autowired
	GerenteService gerenteService;
	
	@GetMapping("/buscar/{id}")
	public GerenteGetDTO buscarPorId(@PathVariable Integer id) {
		return gerenteService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<GerenteGetDTO> listarTodos() {
		return gerenteService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody GerenteDTO gerenteDTO) {
		return gerenteService.salvar(gerenteDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody GerenteDTO gerenteDTO) {
		return gerenteService.atualizar(id, gerenteDTO);
	}
	
	@PutMapping("/ativar/{id}")
	public ResponseEntity<?> ativarLogico(@PathVariable Integer id) {
		return gerenteService.ativarLogico(id);
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerLogico(@PathVariable Integer id) {
		return gerenteService.removerLogico(id);
	}
	
	
}
