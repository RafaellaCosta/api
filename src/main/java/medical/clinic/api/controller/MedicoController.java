package medical.clinic.api.controller;

import jakarta.validation.Valid;
import medical.clinic.api.controller.response.MedicoResponse;
import medical.clinic.api.dto.DadosCadastroMedico;
import medical.clinic.api.entity.MedicoEntity;
import medical.clinic.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping(path = "/add")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new MedicoEntity(dados));
    }

    @GetMapping(path = "/buscarMedicos")
    public Page<MedicoResponse> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(MedicoResponse::new);
    }
}
