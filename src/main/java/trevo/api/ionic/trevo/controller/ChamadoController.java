package trevo.api.ionic.trevo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trevo.api.ionic.trevo.dto.ChamadoDTO;
import trevo.api.ionic.trevo.service.ChamadoService;


@RestController
@RequestMapping(value = "api")
public class ChamadoController {
    @Autowired
    ChamadoService chamadoService;

    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> criaChamado(@RequestBody @Valid ChamadoDTO dto) {
        return chamadoService.criaChamado(dto);
    }

    @PutMapping(value = "/atualiza/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> atualizaChamado(@PathVariable Long id, @RequestBody ChamadoDTO dto) {
        return chamadoService.atualizaChamado(id,dto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscaChamado(@PathVariable Long id) {
        return chamadoService.buscaChamado(id);
    }
    @GetMapping(value = "/listar")
    public ResponseEntity<?> lista() {
        return chamadoService.lista();
    }
    @DeleteMapping(value = "/apagar/{id}")
    public ResponseEntity<?> apagarChamado(@PathVariable Long id) {
        return chamadoService.apagarChamado(id);
    }


}
