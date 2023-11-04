package medical.clinic.api.dto;

import jakarta.validation.constraints.NotNull;
import medical.clinic.api.entity.EnderecoEntity;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco
) {
}
