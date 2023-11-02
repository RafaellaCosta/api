package medical.clinic.api.controller.dto;

public record DadosCadastroPaciente(String nome, String cpf, String email, String telefone, DadosEndereco endereco) {
}
