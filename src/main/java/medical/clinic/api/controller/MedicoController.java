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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
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
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoResponse::new);
    }

    @PutMapping(path = "/atualizar")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping(path = "/deletar/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
