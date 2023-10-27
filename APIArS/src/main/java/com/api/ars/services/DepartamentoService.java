package com.api.ars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.ars.dto.DepartamentoDTO;
import com.api.ars.entities.Departamento;
import com.api.ars.entities.Endereco;
import com.api.ars.repositories.DepartamentoRepository;
import com.api.ars.repositories.EnderecoRepository;
import com.api.ars.repositories.SetorRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	SetorRepository setorRepository;

	//GET Id
	public DepartamentoDTO buscarPorId(Integer id) {
		DepartamentoDTO infoDepartamento = new DepartamentoDTO();
		Departamento departamento = departamentoRepository.findById(id).get();
		infoDepartamento = conversor(departamento);
		return infoDepartamento;
	}

	//GET Listar
	public List<DepartamentoDTO> listarTodos() {
		List<DepartamentoDTO> infoDepartamentos = new ArrayList<>();
		List<Departamento> departamentos = departamentoRepository.findAll();
		for (Departamento departamento : departamentos) {
			infoDepartamentos.add(conversor(departamento));
		}
		return infoDepartamentos;
	}
	
	//POST
	public ResponseEntity<String> salvar(DepartamentoDTO departamentoDTO) {
		Departamento salvarDepartamento = new Departamento();
		Endereco viaCep = enderecoService.pesquisarEndereco(departamentoDTO.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(departamentoDTO.getCep());
		enderecoNovo.setNumero(departamentoDTO.getNumero());
		enderecoNovo.setComplemento(departamentoDTO.getComplemento());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setUf(viaCep.getUf());
		enderecoRepository.save(enderecoNovo);
		salvarDepartamento.setEndereco(enderecoNovo);
		salvarDepartamento.setEmail(departamentoDTO.getEmail());
		salvarDepartamento.setOrcamento(departamentoDTO.getOrcamento());
		salvarDepartamento.setTelefoneFixo(departamentoDTO.getTelefoneFixo());
		salvarDepartamento.setSetor(setorRepository.findByNome(departamentoDTO.getNomeSetor()));
		departamentoRepository.save(salvarDepartamento);
		return ResponseEntity.status(HttpStatus.OK).body("Criação do departamento realizada com sucesso!");
	}
	
	public DepartamentoDTO conversor(Departamento departamento) {
		DepartamentoDTO departamentoConvertido = new DepartamentoDTO();
		departamentoConvertido.setEmail(departamento.getEmail());
		departamentoConvertido.setOrcamento(departamento.getOrcamento());
		departamentoConvertido.setTelefoneFixo(departamento.getTelefoneFixo());
		departamentoConvertido.setNomeSetor(departamento.getSetor().getNome());
		return departamentoConvertido;
	}
	
	//PUT
	public DepartamentoDTO atualizar(Integer id, DepartamentoDTO departamentoDTO) {
		Departamento registroAntigo = departamentoRepository.findById(id).get();

		if (departamentoDTO.getCep() != null) {
			Endereco viaCep = enderecoService.pesquisarEndereco(departamentoDTO.getCep());
			Endereco enderecoNovo = new Endereco();
			enderecoNovo.setBairro(viaCep.getBairro());
			enderecoNovo.setCep(departamentoDTO.getCep());
			enderecoNovo.setComplemento(departamentoDTO.getComplemento());
			enderecoNovo.setLocalidade(viaCep.getLocalidade());
			enderecoNovo.setLogradouro(viaCep.getLogradouro());
			enderecoNovo.setNumero(departamentoDTO.getNumero());
			enderecoNovo.setUf(viaCep.getUf());
			enderecoRepository.save(enderecoNovo);
			registroAntigo.setEndereco(enderecoNovo);
		}
		if (departamentoDTO.getEmail() != null) {
			registroAntigo.setEmail(departamentoDTO.getEmail());
		}
		if (departamentoDTO.getTelefoneFixo() != null) {
			registroAntigo.setTelefoneFixo(departamentoDTO.getTelefoneFixo());
		}
		if (departamentoDTO.getOrcamento() != null) {
			registroAntigo.setOrcamento(departamentoDTO.getOrcamento());
		}
		if (departamentoDTO.getNomeSetor() != null) {
			registroAntigo.setSetor(setorRepository.findByNome(departamentoDTO.getNomeSetor()));
		}
		DepartamentoDTO departamentoConvertido = conversor(registroAntigo);
		departamentoRepository.save(registroAntigo);
		registroAntigo.setId(id);
		return departamentoConvertido;
	
	}
	
	//DELETE
	public void removerLogico(Integer id) {
		Departamento departamento = departamentoRepository.findById(id).get();

		if (departamento != null) {
			departamento.setAtivo(false);
			departamentoRepository.save(departamento);
		}
	}
}
