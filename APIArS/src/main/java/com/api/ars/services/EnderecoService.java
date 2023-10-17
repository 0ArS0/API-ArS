package com.api.ars.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.ars.dto.EnderecoDTO;
import com.api.ars.entities.Endereco;
import com.api.ars.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	//GET Id
	public Endereco buscarPorId(Integer id) {
		return enderecoRepository.findById(id).get();
	}

	//GET Listar
	public List<Endereco> listarTodos() {
		return enderecoRepository.findAll();
	}

	//POST
	public Endereco salvar(EnderecoDTO endereco) {
		
		Endereco viaCep = pesquisarEndereco(endereco.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(endereco.getCep());
		enderecoNovo.setComplemento(endereco.getComplemento());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setNumero(endereco.getNumero());
		enderecoNovo.setUf(viaCep.getUf());
		return enderecoRepository.save(enderecoNovo);
	}

	//PUT
	public Endereco atualizar(Integer id, Endereco endereco) {
		Endereco registroAntigo = buscarPorId(id);

		if (endereco.getCep() != null) {
			registroAntigo.setCep(endereco.getCep());
		}
		registroAntigo.setId(id);
		return enderecoRepository.save(registroAntigo);
	}

	//DELETE
	public void remover(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	
	//Consumo ViaCep
	public Endereco pesquisarEndereco(String cep) { 
		RestTemplate restTemplate = new RestTemplate(); 
		String uri = "http://viacep.com.br/ws/{cep}/json/";
		Map<String, String> params = new HashMap<>();
		params.put("cep", cep); 
		return restTemplate.getForObject(uri, Endereco.class, params);
	}
}