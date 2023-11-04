package medical.clinic.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medical.clinic.api.dto.DadosAtualizacaoMedico;
import medical.clinic.api.dto.DadosCadastroMedico;
import medical.clinic.api.enums.Especialidade;

import java.util.Optional;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private  String cpf;

    private String email;

    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private EnderecoEntity endereco;

    private Boolean ativo;

    public MedicoEntity(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new EnderecoEntity(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        this.nome = (dados.nome() != null) ? dados.nome() : this.nome;
        this.telefone = (dados.telefone() != null) ? dados.telefone() : this.telefone;

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        };
    }

    public void excluir() {
        this.ativo = false;
    }
}
