package medical.clinic.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medical.clinic.api.dto.DadosCadastroPaciente;

@Entity(name = "Paciente")
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoEntity endereco;

    public PacienteEntity(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new EnderecoEntity(dados.endereco());
    }
}
