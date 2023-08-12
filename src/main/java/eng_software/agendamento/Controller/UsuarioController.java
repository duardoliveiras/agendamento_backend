package eng_software.agendamento.Controller;


import eng_software.agendamento.Entity.UsuarioEntity;
import eng_software.agendamento.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostMapping()
    public UsuarioEntity PostUsuario(@RequestBody UsuarioEntity usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioService.PostUsuario(usuario);
    }

    @GetMapping()
    public List<UsuarioEntity> getAll(){
        return usuarioService.getAll();
    }
}
