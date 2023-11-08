package medical.clinic.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
