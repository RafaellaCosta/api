package medical.clinic.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull(message = "Id obrigatório")
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {

}
