package eng_software.agendamento;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*Utilizando o exclude Security, pois por padrao o Spring security
cria uma janela de login nas requisicoes http.
	Login: user
	Senha: gerada a partir da execucao da aplicacao
*/

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoApplication.class, args);
	}

		/*
		A notacao Bean deve ser utilizada quando eu quero que o retorno desse metodo
		seja gerenciado pelo Spring. Dessa forma, esse metodo sera injetado
		em outras camadas da aplicacao
		 */
		@Bean
		public PasswordEncoder getPasswordEncode() {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}


}
