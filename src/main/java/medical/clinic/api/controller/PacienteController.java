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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroPaciente dados,
                                   UriComponentsBuilder uriBuilder) {

        var paciente = pacienteRepository.save(new PacienteEntity(dados));

        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new PacienteResponse(paciente));
    }

    @GetMapping()
    public ResponseEntity<Page<PacienteResponse>>listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {

        var page = pacienteRepository.findAll(paginacao).map(PacienteResponse::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {

        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new PacienteResponse(paciente));
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<PacienteResponse> deletar(@PathVariable Long id) {

        pacienteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var paciente = pacienteRepository.getReferenceById(id);;

        return ResponseEntity.ok(new PacienteResponse(paciente));
    }

}
