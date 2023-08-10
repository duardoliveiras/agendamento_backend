package eng_software.agendamento.Controller;

import eng_software.agendamento.Entity.ClienteEntity;
import eng_software.agendamento.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping("/cliente/{id}")
    public ClienteEntity getById(@PathVariable("id") Long id){
        return clienteService.getById(id);
    }

    @GetMapping("/cliente")
    public List<ClienteEntity> getAll(){
        return clienteService.getAll();
    }

    @PostMapping("/cliente")
    public ClienteEntity postCliente(@RequestBody ClienteEntity cliente){
        return clienteService.postCliente(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteById(@PathVariable("id") Long id){
        clienteService.deleteById(id);
    }

    @DeleteMapping("/cliente")
    public void deleteAll(){
        clienteService.deleteAll();
    }

    /*
    @GetMapping("/cliente")
    public String get(){
        return "oi";
    }

    */

}
