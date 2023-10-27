package com.api.ars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ars.dto.SetorDTO;
import com.api.ars.entities.Setor;
import com.api.ars.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	SetorRepository setorRepository;

	public SetorDTO buscarPorId(Integer id) {
		SetorDTO infoSetor = new SetorDTO();
		Setor setor = setorRepository.findById(id).get();
		infoSetor = conversorDTO(setor);
		return infoSetor;
	}

	public Setor buscarPorNome(SetorDTO nome) {
		return setorRepository.findByNome(nome.getNome());
	}

	public List<SetorDTO> listarTodos() {
		List<SetorDTO> infoSetors = new ArrayList<>();
		List<Setor> setors = setorRepository.findAll();
		for (Setor setor : setors) {
			infoSetors.add(conversorDTO(setor));
		}
		return infoSetors;
	}

	public SetorDTO salvar(SetorDTO setorDTO) {
		Setor salvarSetor = new Setor();
		salvarSetor.setNome(setorDTO.getNome());
		salvarSetor.setDescricao(setorDTO.getDescricao());
		setorRepository.save(salvarSetor);
		SetorDTO setorConvertida = conversorDTO(salvarSetor);

		return setorConvertida;
	}

	public void remover(Integer id) {
		setorRepository.deleteById(id);
	}

	public SetorDTO atualizar(Integer id, SetorDTO setorDTO) {

		Setor registroAntigo = setorRepository.findById(id).get();

		if (setorDTO.getDescricao() != null) {
			registroAntigo.setDescricao(setorDTO.getDescricao());
		}
		if (setorDTO.getNome() != null) {
			registroAntigo.setNome(setorDTO.getNome());
		}
		SetorDTO setorConvertida = conversorDTO(registroAntigo);
		registroAntigo.setId(id);
		setorRepository.save(registroAntigo);
		return setorConvertida;
	}

	public SetorDTO conversorDTO(Setor setor) {
		SetorDTO setorConvertido = new SetorDTO();
		setorConvertido.setNome(setor.getNome());
		setorConvertido.setDescricao(setor.getDescricao());
		return setorConvertido;
	}

}
