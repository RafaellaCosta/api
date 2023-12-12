package medical.clinic.api.controller;

import jakarta.validation.Valid;
import medical.clinic.api.dto.DadosAutenticacao;
import medical.clinic.api.dto.DadosTokenJwt;
import medical.clinic.api.entity.UsuarioEntity;
import medical.clinic.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager autenticacaoManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var autenticacao = autenticacaoManager.authenticate(authenticationToken);
            var tokenJwt = tokenService.tokenGenerate((UsuarioEntity) autenticacao.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
