package medical.clinic.api.controller.dto;

import medical.clinic.api.controller.enuns.Especialidade;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
