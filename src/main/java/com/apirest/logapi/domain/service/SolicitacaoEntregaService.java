package com.apirest.logapi.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.apirest.logapi.domain.exception.NegocioException;
import com.apirest.logapi.domain.model.Cliente;
import com.apirest.logapi.domain.model.Entrega;
import com.apirest.logapi.domain.model.StatusEntrega;
import com.apirest.logapi.domain.repository.ClienteRepository;
import com.apirest.logapi.domain.repository.EntregaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private ClienteRepository clienteRepository;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }

}
