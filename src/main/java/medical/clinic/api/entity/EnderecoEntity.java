package medical.clinic.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medical.clinic.api.dto.DadosEndereco;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public EnderecoEntity(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }
    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }


//    public void atualizarInformacoes(DadosEndereco endereco) {
//        this.logradouro = (endereco.logradouro() != null) ? endereco.logradouro() : this.logradouro;
//        this.bairro = (endereco.bairro() != null) ? endereco.bairro() : this.bairro;
//        this.complemento = (endereco.complemento() != null) ? endereco.complemento() : this.complemento;
//        this.cep = (endereco.cep() != null) ? endereco.cep() : this.cep;
//        this.cidade = (endereco.cidade() != null) ? endereco.cidade() : this.cidade;
//        this.uf = (endereco.uf() != null) ? endereco.uf() : this.uf;
//        this.numero = (endereco.numero() != null) ? endereco.numero() : this.numero;
//    }
}
