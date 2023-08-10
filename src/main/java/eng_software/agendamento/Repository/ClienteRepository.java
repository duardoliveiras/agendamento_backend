package eng_software.agendamento.Repository;

import eng_software.agendamento.Entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}