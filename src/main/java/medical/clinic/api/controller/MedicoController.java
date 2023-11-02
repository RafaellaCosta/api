package medical.clinic.api.controller;

import medical.clinic.api.controller.dto.DadosCadastroMedico;
import medical.clinic.api.models.EnderecoEntity;
import medical.clinic.api.models.MedicoEntity;
import medical.clinic.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        medicoRepository.save(new MedicoEntity(dados));
    }
}
