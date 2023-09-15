package trevo.api.ionic.trevo.dto;


public record ChamadoDTO(
        String imagem,
        String descricao,
        PrioridadeChamado prioridade,
        StatusChamado status,
        Number latitude,
        Number longitude
) {
}
