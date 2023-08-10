package eng_software.agendamento.Service;

import eng_software.agendamento.Entity.ClienteEntity;
import eng_software.agendamento.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteEntity getById(Long id) {
        return clienteRepository.findById(id).get();

    }
    public List<ClienteEntity> getAll(){
        return clienteRepository.findAll();
    }
}
