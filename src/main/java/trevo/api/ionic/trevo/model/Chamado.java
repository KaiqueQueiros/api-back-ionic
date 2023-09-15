package trevo.api.ionic.trevo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trevo.api.ionic.trevo.dto.ChamadoDTO;
import trevo.api.ionic.trevo.dto.PrioridadeChamado;
import trevo.api.ionic.trevo.dto.StatusChamado;

import java.util.UUID;

@Entity
@Table(name = "tb_chamado")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1000000)
    private String imagem;
    private String descricao;
    private PrioridadeChamado prioridade;
    private StatusChamado status;
    private Number latitude;
    private Number longitude;


    public Chamado(ChamadoDTO dto) {
        this.imagem = dto.imagem();
        this.descricao = dto.descricao();
        this.prioridade = dto.prioridade();
        this.status = dto.status();
        this.latitude = dto.latitude();
        this.longitude = dto.longitude();
    }

    public void atualiza(ChamadoDTO dto) {
        if (dto.imagem() != null) {
            this.imagem = dto.imagem();
        }
        if (dto.descricao() != null) {
            this.descricao = dto.descricao();
        }
        if (dto.prioridade() != null) {
            this.prioridade = dto.prioridade();
        }
        if(dto.status() != null) {
            this.status = dto.status();
        }
        if (dto.latitude() != null) {
            this.latitude = dto.latitude();
        }
        if (dto.longitude() != null) {
            this.longitude = dto.longitude();
        }
    }
}

