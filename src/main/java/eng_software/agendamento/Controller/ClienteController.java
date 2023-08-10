package eng_software.agendamento.Controller;

import eng_software.agendamento.Entity.ClienteEntity;
import eng_software.agendamento.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping("/cliente/{id}")
    public ClienteEntity get(@PathVariable("id") Long id){
        return clienteService.getById(id);
    }

    @GetMapping("/cliente")
    public List<ClienteEntity> get(){
        return clienteService.getAll();
    }

    /*
    @GetMapping("/cliente")
    public String get(){
        return "oi";
    }

    */

}
