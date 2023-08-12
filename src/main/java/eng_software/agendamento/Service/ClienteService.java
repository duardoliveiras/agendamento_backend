package eng_software.agendamento.Service;

import eng_software.agendamento.Entity.ClienteEntity;
import eng_software.agendamento.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
Nessa camada eh onde deixamos toda logica de negocio
Aqui criamos todas os metodos necessarios para inserir, consultar e deletar cliente
 */

@Service
public class ClienteService {

    @Autowired // Utilizado para criar um objeto de um classe e incluir sua dependencias
    ClienteRepository clienteRepository;

    /* Utilizamos o clienteRepository que extend JPA Repository pois usaremos os metodos
    do JPA para inserir dados no banco sem precisar usar o SQL.
    Exemplo: findById executa no banco select c1_0.id,c1_0.email,c1_0.nome,c1_0.senha from cliente c1_0 where c1_0.id=?
    */

    public ClienteEntity getById(Long cd_cliente) {
        return clienteRepository.findById(cd_cliente).get();

    }
    public Optional<ClienteEntity> getByEmail(String email){
        return clienteRepository.getByEmail(email);
    }
    public List<ClienteEntity> getAll(){
        return clienteRepository.findAll();
    }

    public ClienteEntity postCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);

    }
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
    public void deleteAll(){
        clienteRepository.deleteAll();
    }

}
