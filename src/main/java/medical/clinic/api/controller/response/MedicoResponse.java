package medical.clinic.api.controller.response;

import medical.clinic.api.entity.MedicoEntity;
import medical.clinic.api.enums.Especialidade;

public record MedicoResponse(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public MedicoResponse(MedicoEntity medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
