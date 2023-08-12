package eng_software.agendamento.Entity;

import jakarta.persistence.*;


// Entidade do banco de dados
// O Spring automaticamente cria uma tabela conforme os atributos da entidade
@Entity
@Table(name="cliente", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cd_cliente;

    @Column(name="nome")
    private String nome;

    @Column(name="senha")
    private String senha;


    @Column(name="email", nullable = false, unique = true)
    private String email;

    public ClienteEntity(){

    }

    public Long getCd_cliente() {
        return cd_cliente;
    }

    public void setCd_cliente(Long cd_cliente) {
        this.cd_cliente = cd_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
