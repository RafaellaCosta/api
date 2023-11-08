package medical.clinic.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medical.clinic.api.enums.Especialidade;

public record DadosCadastroMedico(
        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "Cpf obrigatório")
        String cpf,

        @NotBlank(message = "Email obrigatório")
        @Email
        String email,

        @NotBlank(message = "Telefone obrigatório")
        String telefone,

        @NotBlank(message = "Crm obrigatório")
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull(message = "Especialidade obrigatório")
        Especialidade especialidade,

        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        DadosEndereco endereco) {

}
