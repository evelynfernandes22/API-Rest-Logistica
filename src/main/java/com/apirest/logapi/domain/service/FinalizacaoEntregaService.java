package com.apirest.logapi.domain.service;

import com.apirest.logapi.domain.exception.NegocioException;
import com.apirest.logapi.domain.model.Entrega;
import com.apirest.logapi.domain.model.StatusEntrega;
import com.apirest.logapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class FinalizacaoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId){

        Entrega entrega = buscaEntregaService.buscar(entregaId);

       entrega.finalizar();

        entregaRepository.save(entrega);

    }
}
