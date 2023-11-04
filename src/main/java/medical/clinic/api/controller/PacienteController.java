package medical.clinic.api.controller;

import jakarta.validation.Valid;
import medical.clinic.api.controller.response.PacienteResponse;
import medical.clinic.api.dto.DadosAtualizacaoPaciente;
import medical.clinic.api.dto.DadosCadastroPaciente;
import medical.clinic.api.entity.PacienteEntity;
import medical.clinic.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroPaciente dados) {
        pacienteRepository.save(new PacienteEntity(dados));
    }

    @GetMapping
    public Page<PacienteResponse>listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        return pacienteRepository.findAll(page).map(PacienteResponse::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        PacienteEntity paciente = pacienteRepository.getReferenceById(dados.id());

        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }

}
