package com.api.ars.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.ars.config.JWTUtil;
import com.api.ars.dto.LoginDTO;
import com.api.ars.dto.UserDTO;
import com.api.ars.entities.Endereco;
import com.api.ars.entities.Funcionario;
import com.api.ars.entities.Gerente;
import com.api.ars.entities.Role;
import com.api.ars.entities.User;
import com.api.ars.enums.TipoRoleEnum;
import com.api.ars.repositories.EnderecoRepository;
import com.api.ars.repositories.RoleRepository;
import com.api.ars.repositories.UserRepository;

@Service
public class UserService {

	private EmailService emailService;
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @Autowired
    UserRepository userRepository;
    
	@Autowired
	UserService userService;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseEntity<?> cadastro(@RequestParam String email, @Valid @RequestBody UserDTO userDTO){
		
		Set<String> strRoles = userDTO.getRoles();
		Set<Role> roles = new HashSet<>();

		Endereco viaCep = enderecoService.pesquisarEndereco(userDTO.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(userDTO.getCep());
		enderecoNovo.setComplemento(userDTO.getComplementoAdicional());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setNumero(userDTO.getNumero());
		enderecoNovo.setUf(viaCep.getUf());
		enderecoRepository.save(enderecoNovo);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(enderecoNovo);
		
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_GERENTE)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "FUNCIONARIO":
					Role adminRole = roleRepository.findByName(TipoRoleEnum.ROLE_FUNCIONARIO)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(adminRole);
					User usuarioResumido = new User();
					Funcionario funcionario = new Funcionario();
					String encodedPass = passwordEncoder.encode(userDTO.getPassword());
					usuarioResumido.setNomeUsuario(userDTO.getNomeUsuario());
					usuarioResumido.setEmail(userDTO.getEmail());
					usuarioResumido.setNomeCompleto(userDTO.getNomeCompleto());
					usuarioResumido.setCelular(userDTO.getCelular());
					usuarioResumido.setTelefone(userDTO.getTelefoneFixo());
					usuarioResumido.setCpf(userDTO.getCpf());	
					usuarioResumido.setDataNascimento(userDTO.getDataNascimento());
					usuarioResumido.setRoles(roles);
					usuarioResumido.setPassword(encodedPass);
					usuarioResumido.setEndereco(enderecoNovo);
					userRepository.save(usuarioResumido);
					User usuarioNovo = userRepository.save(usuarioResumido);
					funcionario.setUser(userService.userRepository.findById(usuarioNovo.getIdUser()).get());
					break;
				case "GERENTE":
					Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_GERENTE)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(userRole);
					usuarioResumido = new User();
					Gerente gerente = new Gerente();
					encodedPass = passwordEncoder.encode(userDTO.getPassword());
					usuarioResumido.setNomeUsuario(userDTO.getNomeUsuario());
					usuarioResumido.setEmail(userDTO.getEmail());
					usuarioResumido.setNomeCompleto(userDTO.getNomeCompleto());
					usuarioResumido.setCelular(userDTO.getCelular());
					usuarioResumido.setTelefone(userDTO.getTelefoneFixo());
					usuarioResumido.setCpf(userDTO.getCpf());	
					usuarioResumido.setDataNascimento(userDTO.getDataNascimento());
					usuarioResumido.setRoles(roles);
					usuarioResumido.setPassword(encodedPass);
					usuarioResumido.setEndereco(enderecoNovo);
					userRepository.save(usuarioResumido);
					usuarioNovo = userRepository.save(usuarioResumido);
					gerente.setUser(userService.userRepository.findById(usuarioNovo.getIdUser()).get());
				}
			});
		}
		
		emailService.envioEmailCadastro(userDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro efetuado com sucesso!");
	}
	
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO body) {
		try {
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getEmail(), body.getPassword());

			authManager.authenticate(authInputToken);
			
			User user = userService.userRepository.findByEmail(body.getEmail()).get();
			User usuarioResumido = new User();
			
			usuarioResumido.setNomeUsuario(user.getNomeUsuario());
			usuarioResumido.setEmail(user.getEmail());
			usuarioResumido.setNomeCompleto(user.getNomeCompleto());
			usuarioResumido.setCelular(user.getCelular());
			usuarioResumido.setTelefone(user.getTelefone());
			usuarioResumido.setCpf(user.getCpf());
			usuarioResumido.setDataNascimento(user.getDataNascimento());
			usuarioResumido.setIdUser(user.getIdUser());
			usuarioResumido.setRoles(user.getRoles());
			
			String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

			return ResponseEntity.status(HttpStatus.OK).body("Login efetuado com sucesso!\n\nToken:"+token);
		} catch (AuthenticationException authExc) {
			throw new RuntimeException("Credenciais Invalidas");
		}
	}

	public List<User> listarTodos() {
		return userRepository.findAll();
	}
	
}
