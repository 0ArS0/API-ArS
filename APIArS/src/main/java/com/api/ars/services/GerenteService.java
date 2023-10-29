package com.api.ars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.ars.dto.DepartamentoDataDTO;
import com.api.ars.dto.GerenteDTO;
import com.api.ars.dto.GerenteDataDTO;
import com.api.ars.dto.GerenteGetDTO;
import com.api.ars.entities.Gerente;
import com.api.ars.entities.User;
import com.api.ars.repositories.DepartamentoRepository;
import com.api.ars.repositories.GerenteRepository;
import com.api.ars.repositories.UserRepository;

@Service
public class GerenteService {

	
	@Autowired
	GerenteRepository gerenteRepository;

	@Autowired
	DepartamentoService departamentoService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@Autowired
	DepartamentoRepository departamentoRepository;
	
	private EmailService emailService;
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

	public GerenteGetDTO buscarPorId(Integer id) {
		GerenteGetDTO infoGerente = new GerenteGetDTO();
		Gerente gerente = gerenteRepository.findById(id).get();
		infoGerente = conversorGet(gerente);
		return infoGerente;
	}
	
	public List<GerenteGetDTO> listarTodos() {
		List<GerenteGetDTO> infoGerentes = new ArrayList<>();
		List<Gerente> gerentes = gerenteRepository.findAll();
		for (Gerente gerente : gerentes) {
			infoGerentes.add(conversorGet(gerente));
		}
		return infoGerentes;
	}

	public ResponseEntity<String> salvar(GerenteDTO gerenteDTO) {
		Gerente salvarGerente = new Gerente();
		salvarGerente.setSalario(gerenteDTO.getSalario());
		salvarGerente.setDataContratacao(gerenteDTO.getDataContratacao());
		salvarGerente.setDepartamento(departamentoRepository.findById(gerenteDTO.getDepartamento()).get());
		salvarGerente.setNomeUsuario(gerenteDTO.getNomeUsuario());
		salvarGerente.setUser(userRepository.findByNomeUsuario(gerenteDTO.getNomeUsuario()));
		gerenteRepository.save(salvarGerente);

		return ResponseEntity.status(HttpStatus.OK)
				.body("Contratação do gerente realizada com sucesso!");
	}

	public GerenteDTO conversor(Gerente gerente) {
		GerenteDTO gerenteConvertido = new GerenteDTO();
		gerenteConvertido.setSalario(gerente.getSalario());
		gerenteConvertido.setDataContratacao(gerente.getDataContratacao());
		gerenteConvertido.setDepartamento(gerente.getDepartamento().getId());
		gerenteConvertido.setNomeUsuario(gerente.getNomeUsuario());
		return gerenteConvertido;
	}

	public GerenteGetDTO conversorGet(Gerente gerente) {
		GerenteGetDTO gerenteConvertido = new GerenteGetDTO();
		User user = userRepository.findById(gerente.getUser().getIdUser()).get();

		DepartamentoDataDTO depart = new DepartamentoDataDTO();
		depart.setCepDepartamento(gerente.getDepartamento().getEndereco().getCep());
		depart.setEmailDepartamento(gerente.getDepartamento().getEmail());
		depart.setLocalidadeDepartamento(gerente.getDepartamento().getEndereco().getLocalidade());
		depart.setSetorDepartamento(gerente.getDepartamento().getSetor().getNome());
		depart.setTelefoneDepartamento(gerente.getDepartamento().getTelefoneFixo());
		GerenteDataDTO func = new GerenteDataDTO();
		func.setDepartamentoData(depart);
		func.setSalarioGerente(gerente.getSalario());
		func.setDataContratacaoGerente(gerente.getDataContratacao());
		func.setDataNascimentoGerente(user.getDataNascimento());
		func.setLocalidadeGerente(user.getEndereco().getLocalidade());
		func.setEmailGerente(user.getEmail());
		func.setCepGerente(user.getEndereco().getCep());
		func.setCelularGerente(user.getCelular());
		func.setNomeCompletoGerente(user.getNomeCompleto());
		gerenteConvertido.setGerenteData(func);
		return gerenteConvertido;
	}

	public ResponseEntity<String> atualizar(Integer id, GerenteDTO gerenteDTO) {
		Gerente registroAntigo = gerenteRepository.findById(id).get();

		if (gerenteDTO.getDepartamento() != null) {
			registroAntigo.setDepartamento(departamentoRepository.findById(gerenteDTO.getDepartamento()).get());
		}
		if (gerenteDTO.getSalario() != null) {
			registroAntigo.setSalario(gerenteDTO.getSalario());
		}
		if (gerenteDTO.getNomeUsuario() != null) {
			User user = userRepository.findByNomeUsuario(registroAntigo.getNomeUsuario());
			user.setNomeUsuario(gerenteDTO.getNomeUsuario());
			registroAntigo.setNomeUsuario(gerenteDTO.getNomeUsuario());
			userRepository.save(user);
		}
		
		registroAntigo.setId(id);
		gerenteRepository.save(registroAntigo);
		return ResponseEntity.status(HttpStatus.OK).body("Atualização de dados realizada com sucesso!");
	}
	
	public ResponseEntity<String> removerLogico(Integer id) {
		Gerente gerente = gerenteRepository.findById(id).get();

		if (gerente != null) {
			gerente.setAtivo(false);
			gerenteRepository.save(gerente);
		}

		//emailService.envioEmailDesativacaoContaGerente(conversor(gerenteRepository.findById(id).get()));
		return ResponseEntity.status(HttpStatus.OK).body("Gerente(a) desativado com sucesso, um email será enviado para ele(a)!");
	}

	public ResponseEntity<String> ativarLogico(Integer id) {
		Gerente gerente = gerenteRepository.findById(id).get();

		if (gerente != null) {
			gerente.setAtivo(true);
			gerenteRepository.save(gerente);
		}

		//emailService.envioEmailAtivacaoContaGerente(conversor(gerenteRepository.findById(id).get()));
		return ResponseEntity.status(HttpStatus.OK).body("Gerente(a) ativado com sucesso, um email será enviado para ele(a)!");
	}
	
}
