package medical.clinic.api.controller;

import medical.clinic.api.controller.dto.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public String cadastrar(@RequestBody DadosCadastroMedico json) {
        System.out.println(json);
        return "cadastrado";
    }
}
