package com.apirest.logapi.domain.service;

import com.apirest.logapi.domain.exception.EntidadeNaoEcontradaException;
import com.apirest.logapi.domain.model.Entrega;
import com.apirest.logapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEcontradaException("Entrega não encontrada"));
    }

}
