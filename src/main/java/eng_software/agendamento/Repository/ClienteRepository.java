package eng_software.agendamento.Repository;

import eng_software.agendamento.Entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// O repositorio eh a camada que ira fazer consulta, insercoes e delete no banco
// Ela extende o JPA Repository com a classe entidade pois sera inserido objetos que serao convertidos para o banco
// e extende Long, pois estamos utilizando o Long como Primary Key da entidade
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

    Optional<ClienteEntity> getByEmail(String email);

}