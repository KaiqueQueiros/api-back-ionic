package trevo.api.ionic.trevo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trevo.api.ionic.trevo.model.Chamado;

import java.util.UUID;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}
