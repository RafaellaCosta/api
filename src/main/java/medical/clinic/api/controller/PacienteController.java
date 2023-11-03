package medical.clinic.api.controller;

import medical.clinic.api.controller.dto.DadosCadastroPaciente;
import medical.clinic.api.models.PacienteEntity;
import medical.clinic.api.repository.PacienteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteRepository pacienteRepository;

    @PostMapping
    public void cadastro(@RequestBody DadosCadastroPaciente dados) {
        pacienteRepository.save(new PacienteEntity(dados));
    }
}
