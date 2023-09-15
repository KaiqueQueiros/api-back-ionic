package trevo.api.ionic.trevo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import trevo.api.ionic.trevo.dto.ChamadoDTO;
import trevo.api.ionic.trevo.model.Chamado;
import trevo.api.ionic.trevo.repository.ChamadoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRespository;

    public ResponseEntity<?> criaChamado(@RequestBody ChamadoDTO dto) {
        Chamado chamado = new Chamado(dto);
        if (dto.descricao() == null ) {
            return ResponseEntity.badRequest().body("Favor insira a descrição");
        }
        chamadoRespository.save(chamado);
        return ResponseEntity.ok(chamado);
    }

    public ResponseEntity<?> buscaChamado(Long id) {
        Chamado chamado = chamadoRespository.findById(id).orElse(null);
        return ResponseEntity.ok(chamado);
    }

    public ResponseEntity<?> lista() {
        List<Chamado> chamados = chamadoRespository.findAll();
        return ResponseEntity.ok(chamados);
    }

    public ResponseEntity<?> atualizaChamado(Long id,ChamadoDTO dto) {
        Chamado chamado = chamadoRespository.findById(id).orElse(null);
        assert chamado != null;
        chamado.atualiza(dto);
        chamadoRespository.save(chamado);
        return ResponseEntity.ok(chamado);
    }

    public ResponseEntity<?> apagarChamado(Long id) {
        Chamado chamado = chamadoRespository.findById(id).orElse(null);
        if (chamado!= null) {
            chamadoRespository.deleteById(id);
            return ResponseEntity.ok("Chamado apagado");
        }
        return ResponseEntity.badRequest().build();
    }
}

