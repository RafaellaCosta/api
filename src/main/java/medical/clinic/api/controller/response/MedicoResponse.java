package medical.clinic.api.controller.response;

import medical.clinic.api.entity.EnderecoEntity;
import medical.clinic.api.entity.MedicoEntity;
import medical.clinic.api.enums.Especialidade;

public record MedicoResponse(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoEntity endereco
) {

    public MedicoResponse(MedicoEntity medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
