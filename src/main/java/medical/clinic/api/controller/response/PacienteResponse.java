package medical.clinic.api.controller.response;

import medical.clinic.api.dto.DadosCadastroPaciente;
import medical.clinic.api.entity.PacienteEntity;

public record PacienteResponse(
        String nome,
        String cpf,
        String email,
        String telefone
) {

    public PacienteResponse(PacienteEntity paciente) {
        this(paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }
}
