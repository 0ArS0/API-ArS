package com.api.ars.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ars.dto.SetorDTO;
import com.api.ars.services.SetorService;

@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	SetorService setorService;

	@GetMapping("/buscar/{id}")
	public SetorDTO buscarPorId(@PathVariable Integer id) {
		return setorService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<SetorDTO> listarTodos() {
		return setorService.listarTodos();
	}

	@PostMapping("/salvar")
	public SetorDTO salvar(@Valid @RequestBody SetorDTO setorDTO) {
		return setorService.salvar(setorDTO);
	}

	@PutMapping("/atualizar/{id}")
	public SetorDTO atualizar(@PathVariable Integer id, @Valid @RequestBody SetorDTO setorDTO) {
		return setorService.atualizar(id, setorDTO);
	}

	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Integer id) {
		setorService.remover(id);
	}

}
