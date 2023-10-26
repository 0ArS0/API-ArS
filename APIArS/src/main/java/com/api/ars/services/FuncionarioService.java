package com.api.ars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.ars.dto.DepartamentoDataDTO;
import com.api.ars.dto.FuncionarioDTO;
import com.api.ars.dto.FuncionarioDataDTO;
import com.api.ars.dto.FuncionarioGetDTO;
import com.api.ars.entities.Funcionario;
import com.api.ars.entities.User;
import com.api.ars.repositories.FuncionarioRepository;
import com.api.ars.repositories.UserRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	DepartamentoService departamentoService;
	
	@Autowired
	UserRepository userRepository;

	//GET Id
	public FuncionarioGetDTO buscarPorId(Integer id) {
		FuncionarioGetDTO infoFuncionario = new FuncionarioGetDTO();
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		infoFuncionario = conversorGet(funcionario);
		return infoFuncionario;
	}

	//GET Listar
	public List<FuncionarioGetDTO> listarTodos() {
		List<FuncionarioGetDTO> infoFuncionarios = new ArrayList<>();
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		for (Funcionario funcionario : funcionarios) {
			infoFuncionarios.add(conversorGet(funcionario));
		}
		return infoFuncionarios;
	}
	
	//POST
	public ResponseEntity<String> salvar(FuncionarioDTO funcionarioDTO) {
		Funcionario salvarFuncionario = new Funcionario();
		salvarFuncionario.setSalario(funcionarioDTO.getSalario());
		salvarFuncionario.setDataContratacao(funcionarioDTO.getDataContratacao());
		salvarFuncionario.setDepartamento(departamentoService.buscarPorId(funcionarioDTO.getDepartamento()));
		funcionarioRepository.save(salvarFuncionario);
		
		//Disparo email (pendente)
		return ResponseEntity.status(HttpStatus.OK).body("Contratação do funcionario realizada com sucesso, um email será enviado para o mesmo!");
	}
	
	public FuncionarioDTO conversor(Funcionario funcionario) {
		FuncionarioDTO funcionarioConvertido = new FuncionarioDTO();
		funcionarioConvertido.setSalario(funcionario.getSalario());
		funcionarioConvertido.setDataContratacao(funcionario.getDataContratacao());
		funcionarioConvertido.setDepartamento(funcionario.getDepartamento().getId());
		return funcionarioConvertido;
	}
	
	public FuncionarioGetDTO conversorGet(Funcionario funcionario) {
		FuncionarioGetDTO funcionarioConvertido = new FuncionarioGetDTO();
		User user = userRepository.findById(funcionario.getUser().getIdUser()).get();
		
		DepartamentoDataDTO depart = new DepartamentoDataDTO();
		depart.setCepDepartamento(funcionario.getDepartamento().getEndereco().getCep());
		depart.setEmailDepartamento(funcionario.getDepartamento().getEmail());
		depart.setLocalidadeDepartamento(funcionario.getDepartamento().getEndereco().getLocalidade());
		depart.setNomeDepartamento(funcionario.getDepartamento().getNome());
		depart.setSetorDepartamento(funcionario.getDepartamento().getSetor().getNome());
		depart.setTelefoneDepartamento(funcionario.getDepartamento().getTelefoneFixo());
		FuncionarioDataDTO func = new FuncionarioDataDTO();
		func.setSalarioFuncionario(funcionario.getSalario());
		func.setDataContratacaoFuncionario(funcionario.getDataContratacao());
		func.setDataNascimentoFuncionario(user.getDataNascimento());
		func.setLocalidadeFuncionario(user.getEndereco().getLocalidade());
		func.setEmailFuncionario(user.getEmail());
		func.setCepFuncionario(user.getEndereco().getCep());
		func.setCelularFuncionario(user.getCelular());
		func.setNomeCompletoFuncionario(user.getNomeCompleto());
		func.setDepartamentoData(depart);
		funcionarioConvertido.setFuncionarioData(func);
		return funcionarioConvertido;
	}
	
	//PUT
	public ResponseEntity<String> atualizar(Integer id, FuncionarioDTO funcionarioDTO) {
		
		Funcionario registroAntigo = funcionarioRepository.findById(id).get();
		
		if (funcionarioDTO.getDepartamento() != null) {
			registroAntigo.setDepartamento(departamentoService.buscarPorId(funcionarioDTO.getDepartamento()));
		}
		if (funcionarioDTO.getSalario() != null) {
			registroAntigo.setSalario(funcionarioDTO.getSalario());
		}
		
		registroAntigo.setId(id);
		funcionarioRepository.save(registroAntigo);
		//Disparo email (pendente)
		return ResponseEntity.status(HttpStatus.OK).body("Atualização de dados realizada com sucesso!");
	}
	
	//DELETE
	public ResponseEntity<String> removerLogico(Integer id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();

		if (funcionario != null) {
			funcionario.setAtivo(false);
			funcionarioRepository.save(funcionario);
		}
		
		//Disparo email (pendente)
		return ResponseEntity.status(HttpStatus.OK).body("Funcionario desativado com sucesso!");
	}
	
	public ResponseEntity<String> ativarLogico(Integer id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();

		if (funcionario != null) {
			funcionario.setAtivo(true);
			funcionarioRepository.save(funcionario);
		}
		
		//Disparo email (pendente)
		return ResponseEntity.status(HttpStatus.OK).body("Funcionario ativado com sucesso!");
	}
}
