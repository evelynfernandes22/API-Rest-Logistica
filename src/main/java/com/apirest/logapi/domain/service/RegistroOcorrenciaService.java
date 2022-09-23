package com.apirest.logapi.domain.service;

import com.apirest.logapi.domain.exception.NegocioException;
import com.apirest.logapi.domain.model.Entrega;
import com.apirest.logapi.domain.model.Ocorrencia;
import com.apirest.logapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
       Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrenciaDescricao(descricao);
    }

}
