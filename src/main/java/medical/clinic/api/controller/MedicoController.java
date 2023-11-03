package medical.clinic.api.controller;

import jakarta.validation.Valid;
import medical.clinic.api.controller.dto.DadosCadastroMedico;
import medical.clinic.api.models.MedicoEntity;
import medical.clinic.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new MedicoEntity(dados));
    }
}
