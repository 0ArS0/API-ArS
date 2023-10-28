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
import com.api.ars.services.DepartamentoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
	@ApiOperation(value="Retorna um departamento", notes="Departamento")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna um departamento"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/buscar/{id}")
	public DepartamentoDTO buscarPorId(@PathVariable Integer id) {
		return departamentoService.buscarPorId(id);
	}
	
	@ApiOperation(value="Lista todos os departamentos", notes="Departamento")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Lista todos os departamentos"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/listar")
	public List<DepartamentoDTO> listarTodos() {
		return departamentoService.listarTodos();
	}
	
	@ApiOperation(value="Cria um departamento", notes="Departamento")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Cria um departamento"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody DepartamentoDTO departamentoDTO) {
		return departamentoService.salvar(departamentoDTO);
	}
	
	@ApiOperation(value="Atualiza um departamento", notes="Departamento")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Atualiza um departamento"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PutMapping("/atualizar/{id}")
	public DepartamentoDTO atualizar(@PathVariable Integer id, @RequestBody DepartamentoDTO departamentoDTO) {
		return departamentoService.atualizar(id, departamentoDTO);
	}
	
	@ApiOperation(value="Ativa um departamento", notes="Departamento")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Ativa um departamento"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PutMapping("/ativar/{id}")
	public ResponseEntity<?> ativarLogico(@PathVariable Integer id) {
		return departamentoService.ativarLogico(id);
	}
	
	@ApiOperation(value="Desativa um departamento", notes="Departamento")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Desativa um departamento"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerLogico(@PathVariable Integer id) {
		return departamentoService.removerLogico(id);
	}
	
	
}
