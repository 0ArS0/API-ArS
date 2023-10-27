package com.api.ars.services;

import java.time.LocalDate;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.api.ars.dto.FuncionarioDTO;
import com.api.ars.dto.UserDTO;
import com.api.ars.entities.User;
import com.api.ars.repositories.UserRepository;

@Configuration
@Service
public class EmailService {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	
	private JavaMailSender emailSender;

	// no email o @Autowired é feito no construtor por causa da dependência
	@Autowired
	public void setJavaMailSender(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.port}")
	private Integer port;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${spring.mail.password}")
	private String password;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();
		emailSender.setHost(host);
		emailSender.setPort(port);
		emailSender.setUsername(username);
		emailSender.setPassword(password);
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		emailSender.setJavaMailProperties(prop);
		return emailSender;
	}

	public void envioEmailCadastro(UserDTO user) {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("grupo5api20232@gmail.com");
			helper.setTo(user.getEmail());
			helper.setSubject("Cadastro concluido!");

			LocalDate localDate = LocalDate.now();

			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("		<img src=\"cid:logo1\">\r\n");
			builder.append("			<h1>Confirmação de Cadastro</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Olá,\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Agradecemos por escolher a GRUPO 5 ENTERPRISE e se cadastrar em nossa plataforma! Estamos felizes em tê-lo a bordo. :D\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Aqui estão os detalhes do seu cadastro:\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Nome de Usuário: \r\n");
			builder.append(user.getNomeUsuario());
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Endereço de E-mail: \r\n");
			builder.append(user.getEmail());
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Data de Cadastro: \r\n");
			builder.append(localDate);
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Você terá acesso a um mundo de recursos e oportunidades. Explore nossa plataforma para descobrir como podemos ajudá-lo a atingir seus objetivos.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Se você tiver alguma dúvida ou precisar de assistência, não hesite em entrar em contato conosco pelo e-mail: grupo5api20232@gmail.com. Nossa equipe de suporte estará pronta para ajudar.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Atenciosamente,\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			A Equipe da GRUPO 5 ENTERPRISE.\r\n");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");

			helper.setText(builder.toString(), true);
			ClassPathResource img = new ClassPathResource("img/logo_grupo_5.png");
			helper.addInline("logo1", img);
			emailSender.send(mensagemCadastro);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void envioEmailDesativacaoContaFuncionario(FuncionarioDTO funcionarioDTO) {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		
		User user = userRepository.findByNomeUsuario(funcionarioDTO.getNomeUsuario());
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("grupo5api20232@gmail.com");
			helper.setTo(user.getEmail());
			helper.setSubject("Desativação de Conta de Funcionario!");

			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("		<img src=\"cid:logo2\">\r\n");
			builder.append("			<h1>Desativação de Conta de Cliente</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Olá \r\n");
			builder.append(funcionarioDTO.getNomeUsuario());
			builder.append(",");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Estamos entrando em contato para informar que sua conta na GRUPO 5 ENTERPRISE foi desativada.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Motivo da Desativação:\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Não tem um motivo, a gente desativou por que sim\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Caso tenha alguma dúvida ou precise de mais informações sobre a desativação de sua conta, entre em contato conosco.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Agradecemos por ter sido parte de nossa comunidade e lamentamos por qualquer inconveniência que isso possa causar.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Atenciosamente,\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			A Equipe da GRUPO 5 ENTERPRISE\r\n");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");

			helper.setText(builder.toString(), true);
			ClassPathResource img = new ClassPathResource("img/logo_grupo_5.png");
			helper.addInline("logo2", img);
			emailSender.send(mensagemCadastro);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void envioEmailTrocaSenha(User user) {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("grupo5api20232@gmail.com");
			helper.setTo(user.getEmail());
			helper.setSubject("Troca de senha");

			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("		<img src=\"cid:logo3\">\r\n");
			builder.append("			<h1>Confirmação de Troca de Senha</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Olá \r\n");
			builder.append(user.getNomeUsuario());
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Este e-mail é para confirmar que sua solicitação de troca de senha foi bem-sucedida.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Aqui estão os detalhes da sua conta:\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Nome de Usuário: {nome_usuario}\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Sua senha foi atualizada com sucesso e sua conta está protegida. Se você não solicitou essa alteração ou acredita que houve algum problema, entre em contato conosco imediatamente para garantir a segurança da sua conta.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append(
					"			Para quaisquer dúvidas ou necessidades adicionais, não hesite em nos contatar. Estamos aqui para ajudar.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Atenciosamente,\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			A Equipe da GRUPO 5 ENTERPRISE\r\n");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");

			helper.setText(builder.toString(), true);
			ClassPathResource img = new ClassPathResource("img/logo_grupo_5.png");
			helper.addInline("logo3", img);
			emailSender.send(mensagemCadastro);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	public void envioEmailAtivacaoContaFuncionario(FuncionarioDTO funcionarioDTO) {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		
		User user = userRepository.findByNomeUsuario(funcionarioDTO.getNomeUsuario());
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("grupo5api20232@gmail.com");
			helper.setTo(user.getEmail());
			helper.setSubject("Ativacao de Conta de Funcionario!");

			StringBuilder builder = new StringBuilder();

			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("		<img src=\"cid:logo4\">\r\n");
			builder.append("			<h1>Ativação de Conta</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			Olá \r\n");
			builder.append(funcionarioDTO.getNomeUsuario());
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Temos o prazer de informar que sua conta na GRUPO 5 ENTERPRISE foi ativada com sucesso.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Você agora tem acesso completo aos nossos serviços e recursos. Sinta-se à vontade para explorar e utilizar a sua conta.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Caso tenha alguma dúvida ou precise de assistência, nossa equipe de suporte está à disposição para ajudá-lo.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Agradecemos por se juntar à GRUPO 5 ENTERPRISE e esperamos proporcionar a melhor experiência possível.\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			<br/>\r\n");
			builder.append("			Atenciosamente,\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<div align=\"left\">\r\n");
			builder.append("			A Equipe da GRUPO 5 ENTERPRISE\r\n");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");

			helper.setText(builder.toString(), true);
			ClassPathResource img = new ClassPathResource("img/logo_grupo_5.png");
			helper.addInline("logo4", img);
			emailSender.send(mensagemCadastro);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}