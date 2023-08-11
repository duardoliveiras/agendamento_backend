package eng_software.agendamento.Controller;

import eng_software.agendamento.Entity.ClienteEntity;
import eng_software.agendamento.Service.ClienteService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
A camada controller eh onde iremos trabalhar com a requisicoes Rest HTTP
Sendo assim, utilizaremos os metodos da classe service e indicaremos como a
aplicacao deve agir de acordo com a requisicao
 */
@RestController()
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/{id}")
    public ClienteEntity getById(@PathVariable("id") Long id){
        return clienteService.getById(id);
    }

    @GetMapping()
    public List<ClienteEntity> getAll(){
        return clienteService.getAll();
    }

    @PostMapping()
    public ClienteEntity postCliente(@RequestBody ClienteEntity cliente){
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        return clienteService.postCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        clienteService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        clienteService.deleteAll();
    }

    @GetMapping("/findEmail/{email}")
    public Optional<ClienteEntity> validaEmail(@PathVariable("email") String email){
        return clienteService.getByEmail(email);
    }

    @GetMapping("/validaSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String email, @RequestParam String senha){
        boolean validado = false;
        Optional<ClienteEntity> cliente = clienteService.getByEmail(email);
                if(cliente.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
                }
                ClienteEntity cliente_find = cliente.get();
                validado = encoder.matches(senha, cliente_find.getSenha());

                HttpStatus status = (validado) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
                return ResponseEntity.status(status).body(validado);

    }



    /*
    @GetMapping("/cliente")
    public String get(){
        return "oi";
    }

    */

}
