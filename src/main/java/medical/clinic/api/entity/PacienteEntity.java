package medical.clinic.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medical.clinic.api.dto.DadosAtualizacaoPaciente;
import medical.clinic.api.dto.DadosCadastroPaciente;

@Embeddable
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

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        this.nome = (dados.nome() != null) ? dados.nome() : this.nome;
        this.email = (dados.email() != null) ? dados.email() : this.email;
        this.telefone = (dados.telefone() != null) ? dados.telefone() : this.telefone;

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
