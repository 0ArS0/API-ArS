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

import com.api.ars.dto.FuncionarioDTO;
import com.api.ars.dto.FuncionarioGetDTO;
import com.api.ars.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping("/buscar/{id}")
	public FuncionarioGetDTO buscarPorId(@PathVariable Integer id) {
		return funcionarioService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<FuncionarioGetDTO> listarTodos() {
		return funcionarioService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody FuncionarioDTO funcionarioDTO) {
		return funcionarioService.salvar(funcionarioDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody FuncionarioDTO funcionarioDTO) {
		return funcionarioService.atualizar(id, funcionarioDTO);
	}
	
	@PutMapping("/ativar/{id}")
	public ResponseEntity<?> ativarLogico(@PathVariable Integer id) {
		return funcionarioService.ativarLogico(id);
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerLogico(@PathVariable Integer id) {
		return funcionarioService.removerLogico(id);
	}
	
	
}
