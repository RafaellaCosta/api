package medical.clinic.api.controller;

import jakarta.validation.Valid;
import medical.clinic.api.controller.response.MedicoResponse;
import medical.clinic.api.dto.DadosAtualizacaoMedico;
import medical.clinic.api.dto.DadosCadastroMedico;
import medical.clinic.api.entity.MedicoEntity;
import medical.clinic.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping(path = "/add")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados,
                                    UriComponentsBuilder uriBuilder) {

        MedicoEntity medico = new MedicoEntity(dados);
        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoResponse(medico));
    }

    @GetMapping(path = "/buscarMedicos")
    public ResponseEntity<Page<MedicoResponse>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {

        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoResponse::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping(path = "/atualizar")
    @Transactional
    public ResponseEntity<MedicoResponse> atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {

        MedicoEntity medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);


        return ResponseEntity.ok(new MedicoResponse(medico));
    }

    @DeleteMapping(path = "/deletar/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {

        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var medico = medicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new MedicoResponse(medico));
    }
}
