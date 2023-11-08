package medical.clinic.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "Cpf obrigatório")
        String cpf,

        @Email
        @NotBlank(message = "Email obrigatório")
        String email,

        @NotBlank(message = "Telefone obrigatório")
        String telefone,

        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        DadosEndereco endereco) {
}
