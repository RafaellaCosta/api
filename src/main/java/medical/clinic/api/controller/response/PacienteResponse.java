package medical.clinic.api.controller.response;

import medical.clinic.api.entity.EnderecoEntity;
import medical.clinic.api.entity.PacienteEntity;

public record PacienteResponse(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        EnderecoEntity endereco
) {

    public PacienteResponse(PacienteEntity paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }
}
