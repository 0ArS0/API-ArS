package com.api.ars.controllers;
 
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.ars.config.JWTUtil;
import com.api.ars.dto.LoginDTO;
import com.api.ars.dto.UserDTO;
import com.api.ars.entities.Endereco;
import com.api.ars.entities.Funcionario;
import com.api.ars.entities.Role;
import com.api.ars.entities.User;
import com.api.ars.enums.TipoRoleEnum;
import com.api.ars.repositories.EnderecoRepository;
import com.api.ars.repositories.RoleRepository;
import com.api.ars.services.EmailService;
import com.api.ars.services.EnderecoService;
import com.api.ars.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private EmailService emailService;
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
    
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

	@PostMapping("/registro")
	public ResponseEntity<String> cadastro(@RequestParam String email, @Valid @RequestBody UserDTO user) {

		Set<String> strRoles = user.getRoles();
		Set<Role> roles = new HashSet<>();

		Endereco viaCep = enderecoService.pesquisarEndereco(user.getCep());
		Endereco enderecoNovo = new Endereco();
		enderecoNovo.setBairro(viaCep.getBairro());
		enderecoNovo.setCep(user.getCep());
		enderecoNovo.setComplemento(user.getComplementoAdicional());
		enderecoNovo.setLocalidade(viaCep.getLocalidade());
		enderecoNovo.setLogradouro(viaCep.getLogradouro());
		enderecoNovo.setNumero(user.getNumero());
		enderecoNovo.setUf(viaCep.getUf());
		enderecoRepository.save(enderecoNovo);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(enderecoNovo);
		
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_USUARIO)
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
					String encodedPass = passwordEncoder.encode(user.getPassword());
					usuarioResumido.setNomeUsuario(user.getNomeUsuario());
					usuarioResumido.setEmail(user.getEmail());
					usuarioResumido.setNomeCompleto(user.getNome());
					usuarioResumido.setCelular(user.getCelular());
					usuarioResumido.setTelefone(user.getTelefoneFixo());
					usuarioResumido.setCpf(user.getCpf());	
					usuarioResumido.setDataNascimento(user.getDataNascimento());
					usuarioResumido.setRoles(roles);
					usuarioResumido.setPassword(encodedPass);
					usuarioResumido.setEndereco(enderecoNovo);
					userService.save(usuarioResumido);
					User usuarioNovo = userService.save(usuarioResumido);
					funcionario.setUser(userService.findById(usuarioNovo.getIdUser()));
					break;
				case "USUARIO":
					Role userRole = roleRepository.findByName(TipoRoleEnum.ROLE_USUARIO)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(userRole);
				}
			});
		}

		emailService.envioEmailCadastro(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro efetuado com sucesso!");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO body) {
		try {
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getEmail(), body.getPassword());

			authManager.authenticate(authInputToken);
			
			User user = userService.findByEmail(body.getEmail());
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

}
