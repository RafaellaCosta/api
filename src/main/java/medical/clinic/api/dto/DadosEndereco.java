package medical.clinic.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "Logradouro obrigatório")
        String logradouro,

        @NotBlank(message = "Bairro obrigatório")
        String bairro,

        @NotBlank(message = "CEP obrigatório")
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank(message = "Cidade obrigatório")
        String cidade,

        @NotBlank(message = "UF obrigatório")
        String uf,

        String numero,

        String complemento) {
}
