package eng_software.agendamento.Service;


import eng_software.agendamento.Entity.ClienteEntity;
import eng_software.agendamento.Entity.UsuarioEntity;
import eng_software.agendamento.Repository.ClienteRepository;
import eng_software.agendamento.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public UsuarioEntity PostUsuario(UsuarioEntity usuario){
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> getAll(){
        return usuarioRepository.findAll();
    }


}
