package eng_software.agendamento.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cd_medico;

    private String especialidade;

    @OneToOne
    @JoinColumn(name = "cd_usuario")
    private UsuarioEntity usuarioEntity;
}
